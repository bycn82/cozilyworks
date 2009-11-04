package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class MemberDecl extends CodeDocument{
	public FieldDeclaration fielddeclaration;
	public void setFieldDeclaration(FieldDeclaration t){
		this.fielddeclaration=t;
	}
	public MethodDeclaration methoddeclaration;
	public void setMethodDeclaration(MethodDeclaration t){
		this.methoddeclaration=t;
	}
	public ClassDeclaration classdeclaration;
	public void setClassDeclaration(ClassDeclaration t){
		this.classdeclaration=t;
	}
	public InterfaceDeclaration interfacedeclaration;
	public void setInterfaceDeclaration(InterfaceDeclaration t){
		this.interfacedeclaration=t;
	}
	public void visit(){
		if(coz==0){
			//"fieldDeclaration";
			add(fielddeclaration);
		}
		if(coz==1){
			//"methodDeclaration";
			add(methoddeclaration);
		}
		if(coz==2){
			//"classDeclaration";
			add(classdeclaration);
		}
		if(coz==3){
			//"interfaceDeclaration";
			add(interfacedeclaration);
		}
	}
}
