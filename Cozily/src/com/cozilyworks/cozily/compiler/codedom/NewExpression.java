package com.cozilyworks.cozily.compiler.codedom;

public class NewExpression implements Expression{
	public String type=null;
	public Expression argExp=null;
	public NewExpression(String type,Expression argExp){
		this.type=type;
		this.argExp=argExp;
	}
	public String toString(){
		return "new "+type+"("+((ArgumentExpression)argExp).type+" "+((ArgumentExpression)argExp).arg+")";
	}
}
