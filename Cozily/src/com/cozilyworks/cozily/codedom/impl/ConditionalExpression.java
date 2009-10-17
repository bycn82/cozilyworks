package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class ConditionalExpression extends CodeDocument{
	private ConditionalOrExpression conditionalorexpression;
	public void setConditionalOrExpression(ConditionalOrExpression t){
		this.conditionalorexpression=t;
	}
	private Expression expression;
	public void setExpression(Expression t){
		this.expression=t;
	}
	private ConditionalExpression conditionalexpression;
	public void setConditionalExpression(ConditionalExpression t){
		this.conditionalexpression=t;
	}
	public void visit(){
		if(coz==0){
			add(this.conditionalorexpression);
			
			add(this.expression);
			add(this.conditionalexpression);
		}
	}


}
