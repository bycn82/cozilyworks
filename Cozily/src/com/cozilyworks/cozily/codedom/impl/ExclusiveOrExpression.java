package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class ExclusiveOrExpression extends CodeDocument{
	public AndExpression andexpression;
	public void setAndExpression(AndExpression t){
		this.andexpression=t;
	}
	public List<AndExpression> andexpressions=new ArrayList<AndExpression>();
	public void addAndExpression(AndExpression t){
		this.andexpressions.add(t);
	}
	public void visit(){
		if(coz==0){
			//"andExpression ('^' andExpression)*";
			add(this.andexpression);
			adds("^ %s",this.andexpressions);
		}
	}
}
