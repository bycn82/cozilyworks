package com.cozilyworks.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

public class TestJMS{
	public static String url="tcp://192.168.1.117:61616";
	public static void main(String[] args) throws JMSException{
		new JMSReciever(url,new MyHandler());
		JMSSender sender=new JMSSender(url);
		sender.send(new MyMessageWarpper());
	}
}

class MyHandler implements JMSHandler{
	@Override
	public void handle(Message msg){
		System.out.println(msg);
	}
}

class MyMessageWarpper implements MessageWarpper{
	private Session session;
	private Message msg;
	public void createMessage(){
		try{
			msg=session.createTextMessage("OK");
		}catch(JMSException e){
			e.printStackTrace();
		}
	}
	public void setSession(Session ses){
		if(session==null){
			session=ses;
		}
	}
	public Message getMessage(){
		return msg;
	}
}