package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class Forstatement extends CodeDocument{
	public VariableModifiers variablemodifiers;
	public void setVariableModifiers(VariableModifiers t){
		this.variablemodifiers=t;
	}
	public Type type;
	public void setType(Type t){
		this.type=t;
	}
	public String identifierStr;
	public void setIDENTIFIER(String t){
		this.identifierStr=t;
	}
	public Expression expression;
	public void setExpression(Expression t){
		this.expression=t;
	}
	public Statement statement;
	public void setStatement(Statement t){
		this.statement=t;
	}
	public ForInit forinit;
	public void setForInit(ForInit t){
		this.forinit=t;
	}
	public ExpressionList expressionlist;
	public void setExpressionList(ExpressionList t){
		this.expressionlist=t;
	}
	public void visit(){
		if(coz==0){
			//"'for' '(' variableModifiers type IDENTIFIER ':' expression ')' statement";
			format("for( %s %s %s: %s) %s",this.variablemodifiers,this.type,this.identifierStr,this.expression,
				this.statement);
		}
		if(coz==1){
			//"'for' '(' forInit? ';' expression? ';' expressionList? ')' statement";
			format("for(%s;%s;%s)%s",this.forinit,this.expression,this.expressionlist,this.statement);
		}
	}
}
