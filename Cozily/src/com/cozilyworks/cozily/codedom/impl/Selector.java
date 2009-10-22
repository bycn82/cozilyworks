package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class Selector extends CodeDocument{
	private String identifierStr;
	public void setIDENTIFIER(String t){
		this.identifierStr=t;
	}
	private Arguments arguments;
	public void setArguments(Arguments t){
		this.arguments=t;
	}
	private SuperSuffix supersuffix;
	public void setSuperSuffix(SuperSuffix t){
		this.supersuffix=t;
	}
	private InnerCreator innercreator;
	public void setInnerCreator(InnerCreator t){
		this.innercreator=t;
	}
	private Expression expression;
	public void setExpression(Expression t){
		this.expression=t;
	}
	public void visit(){
		if(coz==0){
			// "'.' IDENTIFIER arguments?";
			format(".%s %s",this.identifierStr,this.arguments);
		}
		if(coz==1){
			// "'.' 'this'";
			add(".this");
		}
		if(coz==2){
			// "'.' 'super' superSuffix";
			add(".super %s",this.supersuffix);
		}
		if(coz==3){
			// "innerCreator";
			add(innercreator);
		}
		if(coz==4){
			// "'[' expression ']'";
			add("[ %s ]",this.expression);
		}
	}
}
