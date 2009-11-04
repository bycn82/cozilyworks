package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class AndExpression extends CodeDocument{
	public EqualityExpression equalityexpression;
	public void setEqualityExpression(EqualityExpression t){
		this.equalityexpression=t;
	}
	public List<EqualityExpression> equalityexpressions=new ArrayList<EqualityExpression>();
	public void addEqualityExpression(EqualityExpression t){
		this.equalityexpressions.add(t);
	}
	public void visit(){
		if(coz==0){
			//"equalityExpression ('&' equalityExpression)*";
			add(this.equalityexpression);
			adds("& %s",this.equalityexpressions);
		}
	}
}
