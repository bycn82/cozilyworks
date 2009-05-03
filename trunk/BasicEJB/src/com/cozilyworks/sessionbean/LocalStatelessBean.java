package com.cozilyworks.sessionbean;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local({Hello.class})
public class LocalStatelessBean implements Hello{
	public String SayHello(String name){
		return name+" local stateless session bean";
	}
}