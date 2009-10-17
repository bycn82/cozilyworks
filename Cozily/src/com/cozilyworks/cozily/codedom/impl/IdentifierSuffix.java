package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class IdentifierSuffix extends CodeDocument{
	private List<String> bracketss=new ArrayList<String>();
	public void addBRACKETS(String t){
		this.bracketss.add(t);
	}
	private Expression expression;
	public void setExpression(Expression t){
		this.expression=t;
	}
	private Arguments arguments;
	public void setArguments(Arguments t){
		this.arguments=t;
	}
	private NonWildcardTypeArguments nonwildcardtypearguments;
	public void setNonWildcardTypeArguments(NonWildcardTypeArguments t){
		this.nonwildcardtypearguments=t;
	}
	private String identifierStr;
	public void setIDENTIFIER(String t){
		this.identifierStr=t;
	}
	private InnerCreator innercreator;
	public void setInnerCreator(InnerCreator t){
		this.innercreator=t;
	}
	public void visit(){
		if(coz==0){
			for(String bracket:this.bracketss){
				add(bracket);
			}
			add(".class");
		}
		if(coz==1){
			add("[");
			add(this.expression);
			add("]");
		}
		if(coz==2){
			add(this.arguments);
		}
		if(coz==3){
			add(".class");
		}
		if(coz==4){
			add(".");
			add(this.nonwildcardtypearguments);
			add(this.identifierStr);
			add(this.arguments);
		}
		if(coz==5){
			add(".this");
		}
		if(coz==6){
			add(".super");
			add(this.arguments);
		}
		if(coz==7){
			add(this.innercreator);
		}
	}
}
