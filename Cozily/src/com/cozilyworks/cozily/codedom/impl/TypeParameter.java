package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class TypeParameter extends CodeDocument{
	private String identifierStr;
	public void setIDENTIFIER(String t){
		this.identifierStr=t;
	}
	private TypeBound typebound;
	public void setTypeBound(TypeBound t){
		this.typebound=t;
	}
	public void visit(){
		if(coz==0){
			//"IDENTIFIER ('extends' typeBound)?";
			add(this.identifierStr);
			add("extends %s",this.typebound);
		}
	}
}
