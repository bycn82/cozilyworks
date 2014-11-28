#ifndef CONTROLCHANNEL_H_INCLUDED
#define CONTROLCHANNEL_H_INCLUDED

#include "FTPSession.h"

class ControlChannel {
public:
							ControlChannel();
	virtual					~ControlChannel();
    int				        Start(FTPSession*   session);
private:
    int                     InitSocket();
    int                     StartMonitor();

    int                     StartHandler();
};

#endif // CONTROLCHANNEL_H_INCLUDED
