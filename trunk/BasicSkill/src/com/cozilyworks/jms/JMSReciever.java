package com.cozilyworks.jms;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSReciever implements MessageListener{
	private ActiveMQConnectionFactory factory;
	private Connection connection;
	private Session session;
	private Destination destination;
	private JMSHandler handler;
	public JMSReciever(String url,JMSHandler handler) throws JMSException{
		this.handler=handler;
		factory=new ActiveMQConnectionFactory(url);
		connection=factory.createConnection();
		session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
		destination=session.createTopic("topictest.messages");
		MessageConsumer consumer=session.createConsumer(destination);
		consumer.setMessageListener(this);
		connection.start();
	}
	public void onMessage(Message msg){
		handler.handle(msg);
	}
}