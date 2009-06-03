package com.cozilyworks.jms;

import javax.jms.Message;
import javax.jms.Session;

public interface MessageWarpper{
	public void createMessage();
	public Message getMessage();
	public void setSession(Session ses);
}
