package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class EnumDeclaration extends CodeDocument{
	public Modifiers modifiers;
	public void setModifiers(Modifiers t){
		this.modifiers=t;
	}
	public String identifierStr;
	public void setIDENTIFIER(String t){
		this.identifierStr=t;
	}
	public TypeList typelist;
	public void setTypeList(TypeList t){
		this.typelist=t;
	}
	public EnumBody enumbody;
	public void setEnumBody(EnumBody t){
		this.enumbody=t;
	}
	public void visit(){
		if(coz==0){
			//"modifiers 'enum' IDENTIFIER ('implements' typeList)? enumBody";
			format("%s enum %s ",this.modifiers,this.identifierStr);
			add("implements %s",this.typelist);
			add(this.enumbody);
		}
	}
}
