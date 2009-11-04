package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class TypeDeclaration extends CodeDocument{
	public ClassOrInterfaceDeclaration classorinterfacedeclaration;
	public void setClassOrInterfaceDeclaration(ClassOrInterfaceDeclaration t){
		this.classorinterfacedeclaration=t;
	}
	public void visit(){
		if(coz==0){
			//"classOrInterfaceDeclaration";
			add(classorinterfacedeclaration);
		}
		if(coz==1){
			//"';'";
			add(";");
		}
	}
}
