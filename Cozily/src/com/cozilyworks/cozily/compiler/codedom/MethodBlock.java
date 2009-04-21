package com.cozilyworks.cozily.compiler.codedom;

import java.util.ArrayList;
import java.util.List;

public class MethodBlock{
	private String modifier;
	private String name;
	private String returnType;
	private List<AssignStatement> statements=new ArrayList<AssignStatement>();
	public void addStatement(AssignStatement ns){
		this.statements.add(ns);
	}
	public void addAll(List<AssignStatement> nss) {
		this.statements.addAll(nss);
	}
	public String toString(){
		String s="\n";
		if(statements.size()>0)
		for(AssignStatement ns:statements){
			s+=ns.toString()+"\n";
		}
			
		return modifier+" "+returnType+" "+name+"{"+s+"}";
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
