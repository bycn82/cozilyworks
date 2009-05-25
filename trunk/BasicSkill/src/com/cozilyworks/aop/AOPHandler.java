package com.cozilyworks.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AOPHandler implements InvocationHandler{
	private Object orginal;
	public Object bind(Object obj){
		orginal=obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
	}
	public Object invoke(Object proxy,Method method,Object[] args) throws Throwable{
		System.out.println("Begin!");
		Object result=method.invoke(orginal,args);
		System.out.println(result);
		System.out.println("Done!");
		return result;
	}
}
