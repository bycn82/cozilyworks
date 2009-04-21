package com.cozilyworks.cozily.compiler.codedom;

public class ArgumentExpression implements Expression{
	public String type=null;
	public String arg=null;
	public ArgumentExpression(String type,String arg){
		this.type=type;
		this.arg=arg;
	}
	public String toString(){
		if(type!=null&&arg!=null){
			return type+" "+arg;
		}
		return "";
	}
}
