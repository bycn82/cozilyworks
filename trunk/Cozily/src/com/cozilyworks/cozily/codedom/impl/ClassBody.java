package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ClassBody extends CodeDocument{
	private List<ClassBodyDeclaration> classbodydeclarations=new ArrayList<ClassBodyDeclaration>();
	public void addClassBodyDeclaration(ClassBodyDeclaration t){
		this.classbodydeclarations.add(t);
	}
	public void visit(){
		if(coz==0){
			// "'{' classBodyDeclaration* '}'";
			add("{");
			adds(this.classbodydeclarations);
			add("}");
		}
	}
}
