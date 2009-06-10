package com.cozilyworks.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class CozilyContextAttributeListener implements ServletContextAttributeListener{

	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0){
		System.out.println("Context add attribute");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0){
		System.out.println("Context remote attribute");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0){
		System.out.println("Context replace");
	}
}
