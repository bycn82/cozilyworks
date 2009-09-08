package com.cozilyworks.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class SampleAspect {
	@Before("execution(* com.cozilyworks.service.*.getName(..))")
	public void doBeforeInServiceLayer() {
		System.out.println("before getname");
	}
	@After("execution(* com.cozilyworks.service.*.getSize(..))")
	public void doAfterInServiceLayer(){
		System.out.println("after getsize");
	}
	@Around("@annotation(com.cozilyworks.aop.MyANNO)")
	public void doAroundAnno(){
		System.out.println("around anno");
	}

}