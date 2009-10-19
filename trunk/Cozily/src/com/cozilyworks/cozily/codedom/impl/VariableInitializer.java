package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class VariableInitializer extends CodeDocument{
	private ArrayInitializer arrayinitializer;
	public void setArrayInitializer(ArrayInitializer t){
		this.arrayinitializer=t;
	}
	private Expression expression;
	public void setExpression(Expression t){
		this.expression=t;
	}
	public void visit(){
		if(coz==0){
			add(this.arrayinitializer);
		}
		if(coz==1){
			add(this.expression);
		}
	}
}
