package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class InclusiveOrExpression extends CodeDocument{
	public ExclusiveOrExpression exclusiveorexpression;
	public void setExclusiveOrExpression(ExclusiveOrExpression t){
		this.exclusiveorexpression=t;
	}
	public List<ExclusiveOrExpression> exclusiveorexpressions=new ArrayList<ExclusiveOrExpression>();
	public void addExclusiveOrExpression(ExclusiveOrExpression t){
		this.exclusiveorexpressions.add(t);
	}
	public void visit(){
		if(coz==0){
			//"exclusiveOrExpression ('|' exclusiveOrExpression)*";
			add(this.exclusiveorexpression);
			adds("| %s",this.exclusiveorexpressions);
		}
	}
}
