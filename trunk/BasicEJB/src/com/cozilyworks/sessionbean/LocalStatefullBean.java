package com.cozilyworks.sessionbean;

import javax.ejb.Local;
import javax.ejb.Stateful;

@Stateful
@Local({Hello.class})
public class LocalStatefullBean implements Hello{
	public String SayHello(String name){
		return name+" local statefull session bean";
	}
}