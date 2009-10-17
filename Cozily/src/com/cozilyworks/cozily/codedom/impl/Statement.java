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
	private Expression expression2;
	public void setExpression2(Expression x2){
		this.expression2=x2;
	}
	private ParExpression parexpression;
	public void setParExpression(ParExpression t){
		this.parexpression=t;
	}
	private Statement statement;
	public void setStatement(Statement t){
		this.statement=t;
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
	private String semiStr;
	public void setSEMI(String t){
		this.semiStr=t;
	}
	public void visit(){
		if(coz==0){
			add(this.block);
		}
		if(coz==1){
			add("assert");add(this.expression);
			if(this.expression2!=null){
				add(":");add(this.expression2);add(";");
			}
		}
		if(coz==2){
			add("if");
			add(this.parexpression);
			add(this.statement);
			add(this.statement2);
		}
		if(coz==3){
			add(this.forstatement);
		}
		if(coz==4){
			add("while");
			add(this.parexpression);
			add(this.statement);
		}
		if(coz==5){
			add("do");
			add(this.statement);
			add(this.parexpression);
		}
		if(coz==6){
			
			add(this.trystatement);
		}
		if(coz==7){
			add("switch");
			add(this.parexpression);
			add(this.switchblockstatementgroups);
		}
		if(coz==8){
			add("synchronized");
			add(this.parexpression);
			add(this.block);
		}
		if(coz==9){
			add("return");
			add(this.expression);
		}
		if(coz==10){
			add("throw");
			add(this.expression);
		}
		if(coz==11){
			add("break");
			add(this.identifierStr);
		}
		if(coz==12){
			add("continue");
			add(this.identifierStr);
		}
		if(coz==13){
			add(this.expression);
			add(";\n");
		}
		if(coz==14){
			add(this.identifierStr);
			add(this.statement);
		}
		if(coz==15){
			add(this.semiStr);
		}
	}


}
