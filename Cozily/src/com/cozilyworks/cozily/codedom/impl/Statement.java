package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class Statement extends CodeDocument{
	private Block block;
	public void setBlock(Block t){
		this.block=t;
	}
	private Expression expression;
	public void setExpression(Expression t){
		this.expression=t;
	}
	private ParExpression parexpression;
	public void setParExpression(ParExpression t){
		this.parexpression=t;
	}
	private Statement statement;
	public void setStatement(Statement t){
		this.statement=t;
	}
	private Expression expression2;
	public void setExpression2(Expression t){
		this.expression2=t;
	}
	private Statement statement2;
	public void setStatement2(Statement t){
		this.statement2=t;
	}
	private Forstatement forstatement;
	public void setForstatement(Forstatement t){
		this.forstatement=t;
	}
	private Trystatement trystatement;
	public void setTrystatement(Trystatement t){
		this.trystatement=t;
	}
	private SwitchBlockStatementGroups switchblockstatementgroups;
	public void setSwitchBlockStatementGroups(SwitchBlockStatementGroups t){
		this.switchblockstatementgroups=t;
	}
	private String identifierStr;
	public void setIDENTIFIER(String t){
		this.identifierStr=t;
	}
	private String semiStr;
	public void setSEMI(String t){
		this.semiStr=t;
	}
	public void visit(){
		if(coz==0){
			// "block";
			add(block);
		}
		if(coz==1){
			// "'assert'  expression (':' expression)? ';'";\
			add("assert");
			add(this.expression);
			add(": %s",this.expression2);
			add(";\n");
		}
		if(coz==2){
			// "'if' parExpression statement ('else' statement)?";
			format("if %s %s",this.parexpression,this.statement);
			add("else %s",this.statement2);
		}
		if(coz==3){
			// "forstatement";
			add(forstatement);
		}
		if(coz==4){
			// "'while' parExpression statement";
			format("while %s %s",this.parexpression,this.statement);
		}
		if(coz==5){
			// "'do' statement 'while' parExpression ';'";
			format("do %s while %s",this.statement,this.parexpression);
		}
		if(coz==6){
			// "trystatement";
			add(trystatement);
		}
		if(coz==7){
			// "'switch' parExpression '{' switchBlockStatementGroups '}'";
			format("switch %s{ %s }",this.parexpression,this.switchblockstatementgroups);
		}
		if(coz==8){
			// "'synchronized' parExpression block";
			format("synchronized %s %s",this.parexpression,this.block);
		}
		if(coz==9){
			// "'return' expression? ';'";
			format("return %s ;\n",this.expression);
		}
		if(coz==10){
			// "'throw' expression ';'";
			add("throw %s ;\n",this.expression);
		}
		if(coz==11){
			// "'break' IDENTIFIER? ';'";
			format("break %s;\n",this.identifierStr);
		}
		if(coz==12){
			// "'continue'IDENTIFIER? ';'";
			format("contine %s;\n",this.identifierStr);
		}
		if(coz==13){
			// "expression  ';'";
			add("%s ;\n",this.expression);
		}
		if(coz==14){
			// "IDENTIFIER ':' statement";
			format("%s : %s",this.identifierStr,this.statement);
		}
		if(coz==15){
			// "SEMI";
			add(semiStr);
		}
	}
}
