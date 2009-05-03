package com.cozilyworks.sessionbean;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote({Hello.class})
public class RemoteStatelessBean implements Hello{
	public String SayHello(String name){
		return name+" remote stateless session bean";
	}
}
