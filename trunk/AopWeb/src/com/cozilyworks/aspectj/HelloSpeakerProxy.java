package com.cozilyworks.aspectj;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

@Aspect
public class HelloSpeakerProxy{
	@After("execution(* hello(..))")
	public void welcome(){
		System.out.println(", welcome to our pub.");
	}
	public HelloSpeaker getHelloSpeakerProxy(){
		AspectJProxyFactory factory=new AspectJProxyFactory();
		factory.setTarget(new HelloSpeaker());
		factory.addAspect(HelloSpeakerProxy.class);
		return factory.getProxy();
	}
	public static void main(String[] args){
		HelloSpeakerProxy proxy=new HelloSpeakerProxy();
		HelloSpeaker helloSpeaker=proxy.getHelloSpeakerProxy();
		helloSpeaker.hello("Huy Vanpom");
	}
}
