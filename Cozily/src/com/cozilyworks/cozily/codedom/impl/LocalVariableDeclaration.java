package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class LocalVariableDeclaration extends CodeDocument{
	private VariableModifiers variablemodifiers;
	public void setVariableModifiers(VariableModifiers t){
		this.variablemodifiers=t;
	}
	private Type type;
	public void setType(Type t){
		this.type=t;
	}
	private VariableDeclarator variabledeclarator;
	public void setVariableDeclarator(VariableDeclarator t){
		this.variabledeclarator=t;
	}
	private List<VariableDeclarator> variabledeclarators=new ArrayList<VariableDeclarator>();
	public void addVariableDeclarator(VariableDeclarator t){
		this.variabledeclarators.add(t);
	}
	public void visit(){
		if(coz==0){
			// "variableModifiers type variableDeclarator (',' variableDeclarator)*";
			format("%s %s %s",this.variabledeclarators,this.type,this.variabledeclarator);
			adds(", %s",this.variabledeclarators);
		}
	}
}
