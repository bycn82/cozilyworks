package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class ClassOrInterfaceType extends CodeDocument{
	private String identifierStr;
	public void setIDENTIFIER(String t){
		this.identifierStr=t;
	}
	private TypeArguments typearguments;
	public void setTypeArguments(TypeArguments t){
		this.typearguments=t;
	}
	private List<String> identifiers=new ArrayList<String>();
	public void addIDENTIFIER(String string){
		this.identifiers.add(string);
	}
	private List<TypeArguments> typeagumentss=new ArrayList<TypeArguments>();
	public void addTypeArguments(TypeArguments x3){
		this.typeagumentss.add(x3);
	}
	public void visit(){
		add(this.identifierStr);
		add(this.typearguments);
		for(String identifier:this.identifiers){
			add(identifier);
		}
		for(TypeArguments typeargument:this.typeagumentss){
			add(typeargument);
		}
	}
}
