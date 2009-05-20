package com.cozilyworks.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TestNotation {
	public static void main(String[] arg){
		A a=new A();
		Method[] ms=a.getClass().getMethods();
		for(Method m:ms){
			Annotation[] as=m.getAnnotations();
			for(Annotation aa:as){
				if(aa instanceof Cozily){
					System.out.println(((Cozily)aa).name());
				}
			}
		}
	}
}
class A{
	@Cozily(name="sdfsdf")
	public void B(){
		
	}
}
