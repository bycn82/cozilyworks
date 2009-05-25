package com.cozilyworks.aop;
public class StaticProxy implements Foo{
	private Foo foo;
	public StaticProxy(Foo foo){
		this.foo=foo;
	}
	public String getMessage(String arg){
		System.out.println("Begin!");
		String message=foo.getMessage(arg);
		System.out.println("Done!");
		return message;
	}
}
