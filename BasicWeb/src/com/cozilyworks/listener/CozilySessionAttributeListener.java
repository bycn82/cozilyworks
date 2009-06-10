package com.cozilyworks.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class CozilySessionAttributeListener implements HttpSessionAttributeListener{

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0){
		System.out.println("Session add attribute");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0){
		System.out.println("Session remote addtribute");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0){
		System.out.println("session replace");
	}
}
