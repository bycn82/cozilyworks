package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class NormalClassDeclaration extends CodeDocument{
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
	public ClassBody classbody;
	public void setClassBody(ClassBody t){
		this.classbody=t;
	}
	public ExtendTypeList extendtypelist;
	public void setExtendTypeList(ExtendTypeList x3){
		this.extendtypelist=x3;
	}
	public void visit(){
		if(coz==0){
			//"modifiers  'class' IDENTIFIER typeParameters? extendTypeList?? ('implements' typeList)? classBody";
			format("%s class %s %s",this.modifiers,this.identifierStr,this.typeparameters);
			add(this.extendtypelist);
			add(" implements %s",this.typelist);
			add(this.classbody);
		}
	}
}
