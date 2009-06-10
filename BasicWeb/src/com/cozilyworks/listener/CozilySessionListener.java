package com.cozilyworks.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CozilySessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent arg0){
		System.out.println("Session created");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0){
		System.out.println("Session destroyed");
	}
}
