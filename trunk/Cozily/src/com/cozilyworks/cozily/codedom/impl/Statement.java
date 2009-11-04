package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class Statement extends CodeDocument{
	public Block block;
	public void setBlock(Block t){
		this.block=t;
	}
	public Expression expression;
	public void setExpression(Expression t){
		this.expression=t;
	}
	public Expression expression2;
	public void setExpression2(Expression x2){
		this.expression2=x2;
	}
	public ParExpression parexpression;
	public void setParExpression(ParExpression t){
		this.parexpression=t;
	}
	public Statement statement;
	public void setStatement(Statement t){
		this.statement=t;
	}
	public Statement statement2;
	public void setStatement2(Statement x5){
		this.statement2=x5;
	}
	public Forstatement forstatement;
	public void setForstatement(Forstatement t){
		this.forstatement=t;
	}
	public Trystatement trystatement;
	public void setTrystatement(Trystatement t){
		this.trystatement=t;
	}
	public SwitchBlockStatementGroups switchblockstatementgroups;
	public void setSwitchBlockStatementGroups(SwitchBlockStatementGroups t){
		this.switchblockstatementgroups=t;
	}
	public String identifierStr;
	public void setIDENTIFIER(String t){
		this.identifierStr=t;
	}
	public void visit(){
		if(coz==0){
			//"block";
			add(block);
		}
		if(coz==1){
			//"'assert' expression (':' expression)? ';'";
			format("assert %s",this.expression);
			add(": %s",this.expression2);
			add(";");
		}
		if(coz==2){
			//"'if' parExpression statement ('else' statement)?";
			format("if %s %s",this.parexpression,this.statement);
			add("else %s",this.statement2);
		}
		if(coz==3){
			//"forstatement";
			add(forstatement);
		}
		if(coz==4){
			//"'while' parExpression statement";
			format("while %s %s",this.parexpression,this.statement);
		}
		if(coz==5){
			//"'do' statement 'while' parExpression ';'";
			format("do %s while %s ;",this.statement,this.parexpression);
		}
		if(coz==6){
			//"trystatement";
			add(trystatement);
		}
		if(coz==7){
			//"'switch' parExpression '{' switchBlockStatementGroups '}'";
			format("switch %s{ %s }",this.parexpression,this.switchblockstatementgroups);
		}
		if(coz==8){
			//"'synchronized' parExpression block";
			format("synchronized %s %s",this.parexpression,this.block);
		}
		if(coz==9){
			//"'return' expression? ';'";
			format("return %s;",this.expression);
		}
		if(coz==10){
			//"'throw' expression ';'";
			format("throw %s;",this.expression);
		}
		if(coz==11){
			//"'break'IDENTIFIER? ';'";
			format("break %s;",this.identifierStr);
		}
		if(coz==12){
			//"'continue' IDENTIFIER? ';'";
			format("contine %s;",this.identifierStr);
		}
		if(coz==13){
			//"expression  ';'";
			format("%s;",this.expression);
		}
		if(coz==14){
			//"IDENTIFIER ':' statement";
			format("%s:%s;",this.identifierStr,this.statement);
		}
		if(coz==15){
			//"';'";
			add(";");
		}
	}
}
