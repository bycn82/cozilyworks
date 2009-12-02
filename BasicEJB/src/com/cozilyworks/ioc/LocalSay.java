package com.cozilyworks.ioc;
import javax.ejb.Local;
import javax.ejb.Stateless;
@Stateless
@Local(SayAction.class)
public class LocalSay implements SayAction{
	public String SayHello(String name){
		return name+"hi HelloBean from LocalSay";
	}
}
