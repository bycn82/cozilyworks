package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class LocalVariableDeclarationStatement extends CodeDocument{
	private LocalVariableDeclaration localvariabledeclaration;
	public void setLocalVariableDeclaration(LocalVariableDeclaration t){
		this.localvariabledeclaration=t;
	}
	public void visit(){
		if(coz==0){
			// "localVariableDeclaration ';'";
			add(this.localvariabledeclaration);
			add(";\n");
		}
	}
}
