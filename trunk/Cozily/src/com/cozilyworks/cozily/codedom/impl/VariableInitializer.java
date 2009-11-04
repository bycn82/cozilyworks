package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class VariableInitializer extends CodeDocument{
	public ArrayInitializer arrayinitializer;
	public void setArrayInitializer(ArrayInitializer t){
		this.arrayinitializer=t;
	}
	public Expression expression;
	public void setExpression(Expression t){
		this.expression=t;
	}
	public void visit(){
		if(coz==0){
			//"arrayInitializer";
			add(arrayinitializer);
		}
		if(coz==1){
			//"expression";
			add(expression);
		}
	}
}
