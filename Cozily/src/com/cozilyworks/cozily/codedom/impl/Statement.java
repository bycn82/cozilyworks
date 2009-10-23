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
	public void setExpression2(Expression x2){
		this.expression2=x2;
	}
	private Statement statement2;
	public void setStatement2(Statement x5){
		this.statement2=x5;
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
	public void visit(){
		if(coz==0){
			// "block";
			add(block);
		}
		if(coz==1){
			// "'assert' expression (':' expression)? ';'";
			format("assert %s : %s ;",this.expression,this.expression2);
		}
		if(coz==2){
			// "'if' parExpression statement ('else' statement)?";

		}
		if(coz==3){
			// "forstatement";
			add(forstatement);
		}
		if(coz==4){
			// "'while' parExpression statement";
		}
		if(coz==5){
			// "'do' statement 'while' parExpression ';'";
		}
		if(coz==6){
			// "trystatement";
			add(trystatement);
		}
		if(coz==7){
			// "'switch' parExpression '{' switchBlockStatementGroups '}'";
		}
		if(coz==8){
			// "'synchronized' parExpression block";
		}
		if(coz==9){
			// "'return' expression? ';'";
		}
		if(coz==10){
			// "'throw' expression ';'";
		}
		if(coz==11){
			// "'break'IDENTIFIER? ';'";
		}
		if(coz==12){
			// "'continue' IDENTIFIER? ';'";
		}
		if(coz==13){
			// "expression  ';'";
		}
		if(coz==14){
			// "IDENTIFIER ':' statement";
		}
		if(coz==15){
			// "';'";
		}
	}
}
