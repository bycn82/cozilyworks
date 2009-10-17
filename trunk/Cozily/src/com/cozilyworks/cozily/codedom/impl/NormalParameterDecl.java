package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class NormalParameterDecl extends CodeDocument{
	private VariableModifiers variablemodifiers;
	public void setVariableModifiers(VariableModifiers t){
		this.variablemodifiers=t;
	}
	private Type type;
	public void setType(Type t){
		this.type=t;
	}
	private String identifierStr;
	public void setIDENTIFIER(String t){
		this.identifierStr=t;
	}
	private List<String> bracketss=new ArrayList<String>();
	public void addBRACKETS(String t){
		this.bracketss.add(t);
	}
	public void visit(){
		add(this.variablemodifiers);
		add(this.type);
		b();
		add(this.identifierStr);
		for(String bracket:this.bracketss){
			add(bracket);
		}
	}
}
