package com.cozilyworks.cozily.codedom.impl;

public class Declaration{
	private Variable v;
	private Function f;
	public Declaration(Variable v){
		this.v=v;
	}
	public Declaration(Function f){
		this.f=f;
	}
}
