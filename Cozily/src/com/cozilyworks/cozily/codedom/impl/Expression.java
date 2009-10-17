package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class Expression extends CodeDocument{
	private ConditionalExpression conditionalexpression;
	public void setConditionalExpression(ConditionalExpression t){
		this.conditionalexpression=t;
	}
	private AssignmentOperator assignmentoperator;
	public void setAssignmentOperator(AssignmentOperator t){
		this.assignmentoperator=t;
	}
	private Expression expression;
	public void setExpression(Expression t){
		this.expression=t;
	}
	public void visit(){
		if(coz==0){
			add(this.conditionalexpression);
			add(this.assignmentoperator);
			add(this.expression);
		}
	}
}
