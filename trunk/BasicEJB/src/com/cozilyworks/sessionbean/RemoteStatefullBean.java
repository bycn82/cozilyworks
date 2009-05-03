package com.cozilyworks.sessionbean;

import javax.ejb.Remote;
import javax.ejb.Stateful;

@Stateful
@Remote({Hello.class})
public class RemoteStatefullBean implements Hello{
	public String SayHello(String name){
		return name+" remote statefull session bean";
	}
}