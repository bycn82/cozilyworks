package com.cozilyworks.ioc;
import javax.ejb.Remote;
import javax.ejb.Stateless;
@Stateless
@Remote(SayAction.class)
public class RemoteSay implements SayAction{
	public String SayHello(String name){
		return name+"hi HelloBean from RemoteSay";
	}
}
