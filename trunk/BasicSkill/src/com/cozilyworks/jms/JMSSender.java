package com.cozilyworks.jms;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.Destination;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSSender{
	private ActiveMQConnectionFactory factory;
	private Connection connection;
	private Session session;
	private MessageProducer publisher;
	private Destination destination;
	public JMSSender(String url) throws JMSException{
		factory=new ActiveMQConnectionFactory(url);
		connection=factory.createConnection();
		session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
		destination=session.createTopic("topictest.messages");
		publisher=session.createProducer(destination);
		publisher.setDeliveryMode(DeliveryMode.PERSISTENT);
		connection.start();
	}
	public void send(MessageWarpper warpper){
		warpper.setSession(session);
		warpper.createMessage();
		try{
			publisher.send(warpper.getMessage());
		}catch(JMSException e){
			e.printStackTrace();
		}
	}
	public void close(){
		try{
			if(connection!=null){
				connection.stop();
				connection.close();
			}
		}catch(JMSException e){
			e.printStackTrace();
		}
	}
}
