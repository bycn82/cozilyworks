package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class NormalInterfaceDeclaration extends CodeDocument{
	public Modifiers modifiers;
	public void setModifiers(Modifiers t){
		this.modifiers=t;
	}
	public String identifierStr;
	public void setIDENTIFIER(String t){
		this.identifierStr=t;
	}
	public TypeParameters typeparameters;
	public void setTypeParameters(TypeParameters t){
		this.typeparameters=t;
	}
	public TypeList typelist;
	public void setTypeList(TypeList t){
		this.typelist=t;
	}
	public InterfaceBody interfacebody;
	public void setInterfaceBody(InterfaceBody t){
		this.interfacebody=t;
	}
	public void visit(){
		if(coz==0){
			//"modifiers 'interface' IDENTIFIER typeParameters? ('extends' typeList)? interfaceBody";
			format("%s interface %s %s",this.modifiers,this.identifierStr,this.typeparameters);
			add("extends %s",this.typelist);
			add(this.interfacebody);
		}
	}
}
