package com.cozilyworks.jms;

import javax.jms.Message;

public interface JMSHandler{
	public void handle(Message msg);
}
