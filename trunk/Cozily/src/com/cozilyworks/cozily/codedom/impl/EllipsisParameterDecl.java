package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class EllipsisParameterDecl extends CodeDocument{
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
	public void visit(){
		if(coz==0){
			//"variableModifiers type  '...' IDENTIFIER";
			format("%s %s... %s",this.variablemodifiers,this.type,this.identifierStr);
		}
	}
}
