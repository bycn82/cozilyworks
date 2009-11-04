package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class BlockStatement extends CodeDocument{
	public LocalVariableDeclarationStatement localvariabledeclarationstatement;
	public void setLocalVariableDeclarationStatement(LocalVariableDeclarationStatement t){
		this.localvariabledeclarationstatement=t;
	}
	public ClassOrInterfaceDeclaration classorinterfacedeclaration;
	public void setClassOrInterfaceDeclaration(ClassOrInterfaceDeclaration t){
		this.classorinterfacedeclaration=t;
	}
	public Statement statement;
	public void setStatement(Statement t){
		this.statement=t;
	}
	public void visit(){
		if(coz==0){
			//"localVariableDeclarationStatement";
			add(localvariabledeclarationstatement);
		}
		if(coz==1){
			//"classOrInterfaceDeclaration";
			add(classorinterfacedeclaration);
		}
		if(coz==2){
			//"statement";
			add(statement);
		}
	}
}
