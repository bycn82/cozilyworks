package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class InterfaceBody extends CodeDocument{
	private List<InterfaceBodyDeclaration> interfacebodydeclarations=new ArrayList<InterfaceBodyDeclaration>();
	public void addInterfaceBodyDeclaration(InterfaceBodyDeclaration t){
		this.interfacebodydeclarations.add(t);
	}
	public void visit(){
		add("{");
		for(InterfaceBodyDeclaration interfaceBodyDec:this.interfacebodydeclarations){
			add(interfaceBodyDec);
		}
		add("}");
	}
}
