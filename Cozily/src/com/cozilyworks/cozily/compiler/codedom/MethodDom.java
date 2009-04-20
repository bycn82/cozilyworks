package com.cozilyworks.cozily.compiler.codedom;

import java.util.ArrayList;
import java.util.List;

public class MethodDom{
	private String modifier;
	private String name;
	private String returnType;
	private List<NewStatement> statements=new ArrayList<NewStatement>();
	public void addStatement(NewStatement ns){
		this.statements.add(ns);
	}
	public String getReturnType(){
		return returnType;
	}
	public void setReturnType(String returnType){
		this.returnType=returnType;
	}
	public String getModifier(){
		return modifier;
	}
	public void setModifier(String modifier){
		this.modifier=modifier;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
}
