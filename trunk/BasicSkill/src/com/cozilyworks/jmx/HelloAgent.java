package com.cozilyworks.jmx;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.Notification;
import javax.management.NotificationListener;
import javax.management.ObjectName;
import com.sun.jdmk.comm.HtmlAdaptorServer;

public class HelloAgent implements NotificationListener{
	private MBeanServer server=null;
	public HelloAgent(){
		server=MBeanServerFactory.createMBeanServer("HelloAgent");
		HtmlAdaptorServer adapter=new HtmlAdaptorServer();
		HelloWorld hw=new HelloWorld();
		try{
			MyListener listener=new MyListener();
			server.registerMBean(listener,new ObjectName("OK:name=myListener"));
			server.registerMBean(hw,new ObjectName("OK:name=helloWorld"));
			hw.addNotificationListener(listener,null,null);
			hw.addNotificationListener(this,null,null);
			adapter.setPort(8082);
			server.registerMBean(adapter,new ObjectName("OK:name=htmlAdaptor,port=8082"));
			adapter.start();
		}catch(MalformedObjectNameException e){
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}catch(InstanceAlreadyExistsException e){
			e.printStackTrace();
		}catch(MBeanRegistrationException e){
			e.printStackTrace();
		}catch(NotCompliantMBeanException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		System.out.println("HelloAgent is running!");
		HelloAgent agent=new HelloAgent();
		while(true){
			System.out.println(HelloWorld.greeting);
			try{
				Thread.sleep(3000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	public void handleNotification(Notification notification,Object handback){
		System.out.println(notification.getMessage());
	}
}
