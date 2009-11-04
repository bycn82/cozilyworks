package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class ConditionalExpression extends CodeDocument{
	public ConditionalOrExpression conditionalorexpression;
	public void setConditionalOrExpression(ConditionalOrExpression t){
		this.conditionalorexpression=t;
	}
	public Expression expression;
	public void setExpression(Expression t){
		this.expression=t;
	}
	public ConditionalExpression conditionalexpression;
	public void setConditionalExpression(ConditionalExpression t){
		this.conditionalexpression=t;
	}
	public void visit(){
		if(coz==0){
			//"conditionalOrExpression ('?' expression ':' conditionalExpression)?";
			add(this.conditionalorexpression);
			add("? %s",this.expression);
			add(": %s",this.conditionalexpression);
		}
	}
}
