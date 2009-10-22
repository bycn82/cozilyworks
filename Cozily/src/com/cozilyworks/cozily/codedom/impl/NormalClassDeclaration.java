package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class NormalClassDeclaration extends CodeDocument{
	private Modifiers modifiers;
	public void setModifiers(Modifiers t){
		this.modifiers=t;
	}
	private String identifierStr;
	public void setIDENTIFIER(String t){
		this.identifierStr=t;
	}
	private TypeParameters typeparameters;
	public void setTypeParameters(TypeParameters t){
		this.typeparameters=t;
	}
	private Type type;
	public void setType(Type t){
		this.type=t;
	}
	private TypeList typelist;
	public void setTypeList(TypeList t){
		this.typelist=t;
	}
	private ClassBody classbody;
	public void setClassBody(ClassBody t){
		this.classbody=t;
	}
	public void visit(){
		if(coz==0){
			// "modifiers  'class' IDENTIFIER typeParameters? ('extends' type)? ('implements' typeList)? classBody";
			format("%s class %s %s",this.modifiers,this.identifierStr,this.typeparameters);
			add("extends %s",this.type);
			add("implements %s",this.typelist);
			add(this.classbody);
		}
	}
}
