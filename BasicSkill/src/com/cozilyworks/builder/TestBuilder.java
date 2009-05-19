package com.cozilyworks.builder;
/*
 * 把控制流程的代碼和具體功能的代碼分開，
 * 比如建造房子，民工懂得如何建造窗，門等等
 * 但是我們把具體建造的代碼提出民工的類
 * 有設計師來指導民工來具體實施
 */
public class TestBuilder {
	public static void main(String[] arg) {
		MingGong mg=new MingGong();
		Director director=new Director(mg);
		director.construct();
		System.out.println(mg.f);
	}
}
