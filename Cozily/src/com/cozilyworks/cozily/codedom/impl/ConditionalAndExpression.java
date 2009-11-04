package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class ConditionalAndExpression extends CodeDocument{
	public InclusiveOrExpression inclusiveorexpression;
	public void setInclusiveOrExpression(InclusiveOrExpression t){
		this.inclusiveorexpression=t;
	}
	public List<InclusiveOrExpression> inclusiveorexpressions=new ArrayList<InclusiveOrExpression>();
	public void addInclusiveOrExpression(InclusiveOrExpression t){
		this.inclusiveorexpressions.add(t);
	}
	public void visit(){
		if(coz==0){
			//"inclusiveOrExpression ('&&' inclusiveOrExpression)*";
			add(this.inclusiveorexpression);
			formats("&& %s",this.inclusiveorexpressions);
		}
	}
}
