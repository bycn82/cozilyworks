package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class VariableDeclarator extends CodeDocument{
	private String identifierStr;
	public void setIDENTIFIER(String t){
		this.identifierStr=t;
	}
	private List<String> bracketss=new ArrayList<String>();
	public void addBRACKETS(String t){
		this.bracketss.add(t);
	}
	private VariableInitializer variableinitializer;
	public void setVariableInitializer(VariableInitializer t){
		this.variableinitializer=t;
	}
	public void visit(){
		if(coz==0){
			//"IDENTIFIER BRACKETS* ('=' variableInitializer)?";
			add(this.identifierStr);
			adds(this.bracketss);
			add("= %s",this.variableinitializer);
		}
	}
}
