package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class FieldDeclaration extends CodeDocument{
	public Modifiers modifiers;
	public void setModifiers(Modifiers t){
		this.modifiers=t;
	}
	public Type type;
	public void setType(Type t){
		this.type=t;
	}
	public VariableDeclarator variabledeclarator;
	public void setVariableDeclarator(VariableDeclarator t){
		this.variabledeclarator=t;
	}
	public List<VariableDeclarator> variabledeclarators=new ArrayList<VariableDeclarator>();
	public void addVariableDeclarator(VariableDeclarator t){
		this.variabledeclarators.add(t);
	}
	public void visit(){
		if(coz==0){
			//"modifiers type variableDeclarator (',' variableDeclarator)* ';'";
			format("%s %s %s;",this.modifiers,this.type,this.variabledeclarator);
		}
	}
}
