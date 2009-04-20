package com.cozilyworks.cozily.compiler.codedom;

import java.util.ArrayList;
import java.util.List;

public class ProgramDom{
	private String modifier;
	private String name;
	private List<MethodDom> methods=new ArrayList<MethodDom>();
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
