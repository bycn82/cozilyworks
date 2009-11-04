package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class InterfaceBodyDeclaration extends CodeDocument{
	public InterfaceFieldDeclaration interfacefielddeclaration;
	public void setInterfaceFieldDeclaration(InterfaceFieldDeclaration t){
		this.interfacefielddeclaration=t;
	}
	public InterfaceMethodDeclaration interfacemethoddeclaration;
	public void setInterfaceMethodDeclaration(InterfaceMethodDeclaration t){
		this.interfacemethoddeclaration=t;
	}
	public InterfaceDeclaration interfacedeclaration;
	public void setInterfaceDeclaration(InterfaceDeclaration t){
		this.interfacedeclaration=t;
	}
	public ClassDeclaration classdeclaration;
	public void setClassDeclaration(ClassDeclaration t){
		this.classdeclaration=t;
	}
	public void visit(){
		if(coz==0){
			//"interfaceFieldDeclaration";
			add(interfacefielddeclaration);
		}
		if(coz==1){
			//"interfaceMethodDeclaration";
			add(interfacemethoddeclaration);
		}
		if(coz==2){
			//"interfaceDeclaration";
			add(interfacedeclaration);
		}
		if(coz==3){
			//"classDeclaration";
			add(classdeclaration);
		}
		if(coz==4){
			//"';'";
			add(";");
		}
	}
}
