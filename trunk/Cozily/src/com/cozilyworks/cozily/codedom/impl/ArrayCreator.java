package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class ArrayCreator extends CodeDocument{
	public CreatedName createdname;
	public void setCreatedName(CreatedName t){
		this.createdname=t;
	}
	public List<String> bracketss=new ArrayList<String>();
	public void addBRACKETS(String t){
		this.bracketss.add(t);
	}
	public ArrayInitializer arrayinitializer;
	public void setArrayInitializer(ArrayInitializer t){
		this.arrayinitializer=t;
	}
	public List<Expression> expressions=new ArrayList<Expression>();
	public void addExpression(Expression t){
		this.expressions.add(t);
	}
	public void visit(){
		if(coz==0){
			//"'new' createdName BRACKETS+ arrayInitializer";
			String createdName=this.createdname.toString();
			source.addSymbols(createdName);
			//
			add("new %s",createdName);
			adds(this.bracketss);
			add(this.arrayinitializer);
		}
		if(coz==1){
			//"'new' createdName ('[' expression ']')+ BRACKETS*";
			String createdName=this.createdname.toString();
			source.addSymbols(createdName);
			add("new %s",createdName);
			formats("[ %s ]",this.expressions);
			adds(this.bracketss);
		}
	}
}
