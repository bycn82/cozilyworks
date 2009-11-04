package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class ForInit extends CodeDocument{
	public LocalVariableDeclaration localvariabledeclaration;
	public void setLocalVariableDeclaration(LocalVariableDeclaration t){
		this.localvariabledeclaration=t;
	}
	public ExpressionList expressionlist;
	public void setExpressionList(ExpressionList t){
		this.expressionlist=t;
	}
	public void visit(){
		if(coz==0){
			//"localVariableDeclaration";
			add(localvariabledeclaration);
		}
		if(coz==1){
			//"expressionList";
			add(expressionlist);
		}
	}
}
