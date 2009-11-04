package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class InterfaceMethodDeclaration extends CodeDocument{
	public Modifiers modifiers;
	public void setModifiers(Modifiers t){
		this.modifiers=t;
	}
	public TypeParameters typeparameters;
	public void setTypeParameters(TypeParameters t){
		this.typeparameters=t;
	}
	public ReturnType returntype;
	public void setReturnType(ReturnType t){
		this.returntype=t;
	}
	public String identifierStr;
	public void setIDENTIFIER(String t){
		this.identifierStr=t;
	}
	public FormalParameters formalparameters;
	public void setFormalParameters(FormalParameters t){
		this.formalparameters=t;
	}
	public List<String> bracketss=new ArrayList<String>();
	public void addBRACKETS(String t){
		this.bracketss.add(t);
	}
	public QualifiedNameList qualifiednamelist;
	public void setQualifiedNameList(QualifiedNameList t){
		this.qualifiednamelist=t;
	}
	public void visit(){
		if(coz==0){
			//"modifiers typeParameters? returnType IDENTIFIER formalParameters BRACKETS* ('throws' qualifiedNameList)? ';'";
			format("%s %s %s %s %s",this.modifiers,this.typeparameters,this.returntype,this.identifierStr,this.formalparameters);
			adds(this.bracketss);
			add("throws %s",this.qualifiednamelist);
			add(";");
		}
	}
}
