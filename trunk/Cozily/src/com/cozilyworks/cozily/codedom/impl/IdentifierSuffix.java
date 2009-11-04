package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class IdentifierSuffix extends CodeDocument{
	public List<String> bracketss=new ArrayList<String>();
	public void addBRACKETS(String t){
		this.bracketss.add(t);
	}
	public List<Expression> expressions=new ArrayList<Expression>();
	public void addExpression(Expression t){
		this.expressions.add(t);
	}
	public Arguments arguments;
	public void setArguments(Arguments t){
		this.arguments=t;
	}
	public NonWildcardTypeArguments nonwildcardtypearguments;
	public void setNonWildcardTypeArguments(NonWildcardTypeArguments t){
		this.nonwildcardtypearguments=t;
	}
	public String identifierStr;
	public void setIDENTIFIER(String t){
		this.identifierStr=t;
	}
	public InnerCreator innercreator;
	public void setInnerCreator(InnerCreator t){
		this.innercreator=t;
	}
	public void visit(){
		if(coz==0){
			//"BRACKETS+ '.' 'class'";
			adds(this.bracketss);
			add(".class");
		}
		if(coz==1){
			//"('[' expression ']')+";
			adds("[ %s ]",this.expressions);
		}
		if(coz==2){
			//"arguments";
			add(arguments);
		}
		if(coz==3){
			//"'.' 'class'";
			add(".class");
		}
		if(coz==4){
			//"'.' nonWildcardTypeArguments IDENTIFIER arguments";
			format(".%s %s %s",this.nonwildcardtypearguments,this.identifierStr,this.arguments);
		}
		if(coz==5){
			//"'.' 'this'";
			add(".this");
		}
		if(coz==6){
			//"'.' 'super' arguments";
			format(".super %s",this.arguments);
		}
		if(coz==7){
			//"innerCreator";
			add(innercreator);
		}
	}
}
