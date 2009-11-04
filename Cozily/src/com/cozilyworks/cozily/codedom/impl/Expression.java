package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class Expression extends CodeDocument{
	public ConditionalExpression conditionalexpression;
	public void setConditionalExpression(ConditionalExpression t){
		this.conditionalexpression=t;
	}
	public AssignmentOperator assignmentoperator;
	public void setAssignmentOperator(AssignmentOperator t){
		this.assignmentoperator=t;
	}
	public Expression expression;
	public void setExpression(Expression t){
		this.expression=t;
	}
	public void visit(){
		if(coz==0){
			//"conditionalExpression (assignmentOperator expression )?";
			format("%s %s %s",this.conditionalexpression,this.assignmentoperator,this.expression);
		}
	}
}
