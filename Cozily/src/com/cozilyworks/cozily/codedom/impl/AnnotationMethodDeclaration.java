package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class AnnotationMethodDeclaration extends CodeDocument{
	public Modifiers modifiers;
	public void setModifiers(Modifiers t){
		this.modifiers=t;
	}
	public Type type;
	public void setType(Type t){
		this.type=t;
	}
	public String identifierStr;
	public void setIDENTIFIER(String t){
		this.identifierStr=t;
	}
	public ElementValue elementvalue;
	public void setElementValue(ElementValue t){
		this.elementvalue=t;
	}
	public void visit(){
		if(coz==0){
			//"modifiers type IDENTIFIER '(' ')' ('default' elementValue)? ';'";
			format("%s %s %s ()",this.modifiers,this.type,this.identifierStr);
			add("default %s",this.elementvalue);
			add(";");
		}
	}
}
