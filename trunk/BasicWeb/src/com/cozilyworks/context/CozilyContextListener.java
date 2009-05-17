package com.cozilyworks.context;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CozilyContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0){
		System.out.println("Context Destoryed");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0){
		System.out.println("Context initialized");
	}
}
