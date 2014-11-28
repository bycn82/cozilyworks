#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <winsock2.h>

char *str_replace(char *orig, char *rep, char *with) {
    char *result; // the return string
    char *ins;    // the next insert point
    char *tmp;    // varies
    int len_rep;  // length of rep
    int len_with; // length of with
    int len_front; // distance between rep and end of last rep
    int count;    // number of replacements

    if (!orig)
        return NULL;
    if (!rep)
        rep = "";
    len_rep = strlen(rep);
    if (!with)
        with = "";
    len_with = strlen(with);

    ins = orig;
    for (count = 0; tmp = strstr(ins, rep); ++count) {
        ins = tmp + len_rep;
    }

    // first time through the loop, all the variable are set correctly
    // from here on,
    //    tmp points to the end of the result string
    //    ins points to the next occurrence of rep in orig
    //    orig points to the remainder of orig after "end of rep"
    tmp = result = malloc(strlen(orig) + (len_with - len_rep) * count + 1);

    if (!result)
        return NULL;

    while (count--) {
        ins = strstr(orig, rep);
        len_front = ins - orig;
        tmp = strncpy(tmp, orig, len_front) + len_front;
        tmp = strcpy(tmp, with) + len_with;
        orig += len_front + len_rep; // move to next "end of rep"
    }
    strcpy(tmp, orig);
    return result;
}

int main(int argc,char **argv)
{
    int sockfd,n;
    char buff[1024];
    struct sockaddr_in serveraddr;

    if(argc != 4) {
        printf("Usage :%s ip line file\n", argv[0]);
        exit(0);
    }

    //Winsows下启用socket
    WSADATA wsadata;
    if(WSAStartup(MAKEWORD(1,1),&wsadata)==SOCKET_ERROR) {
        printf("WSAStartup() fail\n");
        exit(0);
    }

    //建立socket
    if((sockfd=socket(AF_INET,SOCK_STREAM,0))==-1) {
        printf("socket() fail\n");
        exit(0);
    }

    //设置协议及Port
    memset(&serveraddr,0,sizeof(serveraddr));
    serveraddr.sin_family = AF_INET;
    serveraddr.sin_port=htons(2014);

    //设置IP
    serveraddr.sin_addr.s_addr=inet_addr(argv[1]);

    //连接
    if(connect(sockfd,(struct sockaddr *)&serveraddr,sizeof(serveraddr))==-1) {
        printf("connect() fail\n");
        exit(0);
    }

    sprintf(buff,"%s %s%s\n",argv[2],"/usr/src",str_replace(argv[3],"\\","/")+2);
    send(sockfd,buff,strlen(buff),0);
    //Winsows下关闭socket
    closesocket(sockfd);
    WSACleanup();

    exit(0);
}
