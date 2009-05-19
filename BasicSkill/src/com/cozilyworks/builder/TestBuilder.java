package com.cozilyworks.builder;

public class TestBuilder {
	public static void main(String[] arg) {
		MingGong mg=new MingGong();
		Director director=new Director(mg);
		director.construct();
		System.out.println(mg.f);
	}
}
