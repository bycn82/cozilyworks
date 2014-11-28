#include "StdInc.h"
#include "ControlChannel.h"
#include "Output.h"
#include "FTPSession.h"

#include <windows.h>
#include <winsock2.h>
#include <ws2tcpip.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include <process.h>
#include "Npp/PluginInterface.h"


#define DEFAULT_BUFLEN  512
#define DEFAULT_PORT    "2014"



FTPSession *the_session = NULL;
SOCKET ListenSocket = INVALID_SOCKET;
unsigned monitor_pid;
unsigned handler_pid;
int count=0;

extern NppData nppData;
extern int _global_var_goto_line;


WSADATA wsaData;
int iResult;

void char_to_tchar(char *src,TCHAR *dst){
    int n_len = MultiByteToWideChar(CP_ACP,NULL,src,-1,NULL,0);
    MultiByteToWideChar(CP_ACP,NULL,src,-1,dst,n_len);
}
void tchar_to_char(TCHAR *src,char *dst){
    int n_len = WideCharToMultiByte(CP_ACP,NULL,src,-1,NULL,0,NULL,NULL);
    WideCharToMultiByte(CP_ACP,NULL,src,-1,dst,n_len,NULL,NULL);
}

void MonitorThread(void *arg)
{
    TCHAR wstr[1024];
    char str[1024];
    char *p;
    int pos;
    int count;
    while(1){
        Sleep(1000);
        memset(wstr,0,1024);
        memset(str,0,1024);
        ::GetWindowText(nppData._nppHandle, wstr,1024);
        tchar_to_char(wstr,str);

        p = strstr(str,"[ControlChannl:");
        if(p)
            str[p - str]=0;
        if(!the_session->IsConnected()){
            sprintf(str,"%s[ControlChannl:Not Connected!]",str);
        }else{
            sprintf(str,"%s[ControlChannl:OK]",str);
        }

        memset(wstr,0,1024);
        char_to_tchar(str,wstr);
        ::SetWindowText(nppData._nppHandle,wstr);
    }
}
void trim(char *str)
{
    int i;
    int begin = 0;
    int end = strlen(str) - 1;

    while (isspace(str[begin]))
        begin++;

    while ((end >= begin) && isspace(str[end]))
        end--;

    // Shift all characters back to the start of the string array.
    for (i = begin; i <= end; i++)
        str[i - begin] = str[i];

    str[i - begin] = '\0'; // Null terminate string.
}
void HandlerThread(void *arg)
{
    int iSendResult;
    char recvbuf[DEFAULT_BUFLEN];
    char *cmd;
    int recvbuflen = DEFAULT_BUFLEN;
    SOCKET ClientSocket = INVALID_SOCKET;
    do {
        // Accept a client socket
        ClientSocket = accept(ListenSocket, NULL, NULL);
        if (ClientSocket == INVALID_SOCKET) {
            printf("accept failed with error: %d\n", WSAGetLastError());
        }
        memset(recvbuf,0,DEFAULT_BUFLEN);
        iResult = recv(ClientSocket, recvbuf, recvbuflen, 0);
        if (iResult > 0) {
            cmd=recvbuf;
            _global_var_goto_line=atoi(cmd);
            char *filepath=cmd+1+(strstr(cmd," ")-cmd);
            trim(filepath);
            OutMsg("[ControlChannel] roger that. '%d %s'\n",atoi(cmd),filepath);
            the_session->DownloadFileCache(filepath);
			::ShowWindow(nppData._nppHandle,SW_RESTORE);
            ::SetForegroundWindow(nppData._nppHandle);
        }else if (iResult == 0)
            OutMsg("Connection closing...\n");
        else  {
            OutMsg("recv failed with error: %d\n", WSAGetLastError());
        }
        closesocket(ClientSocket);
    } while (iResult > 0);
}



ControlChannel::ControlChannel()
{
    // Initialize Winsock
    iResult = WSAStartup(MAKEWORD(2,2), &wsaData);
    InitSocket();
}
ControlChannel::~ControlChannel() {
    closesocket(ListenSocket);
    WSACleanup();
}

int ControlChannel::InitSocket(){


    struct addrinfo *result = NULL;
    struct addrinfo hints;


    if (iResult != 0) {
        OutMsg("WSAStartup failed with error: %d\n", iResult);
        return 1;
    }

    ZeroMemory(&hints, sizeof(hints));
    hints.ai_family = AF_INET;
    hints.ai_socktype = SOCK_STREAM;
    hints.ai_protocol = IPPROTO_TCP;
    hints.ai_flags = AI_PASSIVE;

    // Resolve the server address and port
    iResult = getaddrinfo(NULL, DEFAULT_PORT, &hints, &result);
    if ( iResult != 0 ) {
        OutMsg("getaddrinfo failed with error: %d\n", iResult);
        WSACleanup();
        return 1;
    }

    // Create a SOCKET for connecting to server
    ListenSocket = socket(result->ai_family, result->ai_socktype, result->ai_protocol);
    if (ListenSocket == INVALID_SOCKET) {
        OutMsg("socket failed with error: %ld\n", WSAGetLastError());
        freeaddrinfo(result);
        WSACleanup();
        return 1;
    }

    // Setup the TCP listening socket
    iResult = bind( ListenSocket, result->ai_addr, (int)result->ai_addrlen);
    if (iResult == SOCKET_ERROR) {
        OutMsg("bind failed with error: %d\n", WSAGetLastError());
        freeaddrinfo(result);
        closesocket(ListenSocket);
        WSACleanup();
        return 1;
    }

    freeaddrinfo(result);

    iResult = listen(ListenSocket, SOMAXCONN);
    if (iResult == SOCKET_ERROR) {
        OutMsg("listen failed with error: %d\n", WSAGetLastError());
        closesocket(ListenSocket);
        WSACleanup();
        return 1;
    }
    OutMsg("[ControlChannel] listening on port '2014'\n");
    return 0;
}

int ControlChannel::Start(FTPSession *session){
    the_session=session;
    StartMonitor();
    StartHandler();
    return 0;
}
int ControlChannel::StartMonitor(){
     _beginthreadex(NULL,0, (unsigned (__stdcall *) (void *))MonitorThread,(void *)count,0,&monitor_pid);
     return 0;
}

int ControlChannel::StartHandler(){
     _beginthreadex(NULL,0, (unsigned (__stdcall *) (void *))HandlerThread,(void *)count,0,&handler_pid);
     return 0;
}


