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
		add(this.variablemodifiers);
		add(this.type);
		add(this.variabledeclarator);
		for(VariableDeclarator vardec:this.variabledeclarators){
			add(",");
			add(vardec);
		}
	}
}
