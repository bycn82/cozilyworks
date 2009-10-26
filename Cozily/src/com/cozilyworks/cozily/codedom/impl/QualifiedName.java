package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class QualifiedName extends CodeDocument{
	private String identifierStr;
	public void setIDENTIFIER(String t){
		this.identifierStr=t;
		this.symbol(t);
	}
	private List<String> identifiers=new ArrayList<String>();
	public void addIDENTIFIER(String t){
		this.identifiers.add(t);
	}
	public void visit(){
		if(coz==0){
			//"IDENTIFIER ('.' IDENTIFIER)*";
			add(this.identifierStr);
			adds(".%s",this.identifiers);
		}
	}
}
