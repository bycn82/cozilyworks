package com.cozilyworks.jmx;

import javax.management.NotificationListener;

public interface MyListenerMBean extends NotificationListener {
	public void printInfo(String message);
}
