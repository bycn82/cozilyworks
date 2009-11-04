package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class FormalParameter extends CodeDocument{
	public VariableModifiers variablemodifiers;
	public void setVariableModifiers(VariableModifiers t){
		this.variablemodifiers=t;
	}
	public Type type;
	public void setType(Type t){
		this.type=t;
	}
	public String identifierStr;
	public void setIDENTIFIER(String t){
		this.identifierStr=t;
	}
	public List<String> bracketss=new ArrayList<String>();
	public void addBRACKETS(String t){
		this.bracketss.add(t);
	}
	public void visit(){
		if(coz==0){
			//"variableModifiers type IDENTIFIER BRACKETS*";
			format("%s %s %s",this.variablemodifiers,this.type,this.identifierStr);
			adds(this.bracketss);
		}
	}
}
