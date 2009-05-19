package com.cozilyworks.singleton;

public class TestSingleton {
	public static String name=null;
	public synchronized void getInstance(){
		if(name==null){
			name=new String("OK");
		}
	}
	public static void main(String[] arg){
		TestSingleton t=new TestSingleton();
		t.getInstance();
		t.getInstance();
		t.getInstance();
		System.out.println(name);
	}
}
