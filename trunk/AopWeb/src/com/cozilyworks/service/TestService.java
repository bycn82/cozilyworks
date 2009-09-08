package com.cozilyworks.service;

import com.cozilyworks.aop.MyANNO;

public class TestService {

	public void getName() {
		System.out.println("Method getName() invoked");
	}
	public void getSize(){
		System.out.println("Method getSize() invoked");
	}
	@MyANNO
	public void testAnno(){
		System.out.println("method testanno invoked");
	}
}
