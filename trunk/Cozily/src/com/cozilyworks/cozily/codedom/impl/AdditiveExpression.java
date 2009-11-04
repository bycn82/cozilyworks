package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class AdditiveExpression extends CodeDocument{
	public MultiplicativeExpression multiplicativeexpression;
	public void setMultiplicativeExpression(MultiplicativeExpression t){
		this.multiplicativeexpression=t;
	}
	public List<PlusOrMinus> plusorminuss=new ArrayList<PlusOrMinus>();
	public void addPlusOrMinus(PlusOrMinus t){
		this.plusorminuss.add(t);
	}
	public List<MultiplicativeExpression> multiplicativeexpressions=new ArrayList<MultiplicativeExpression>();
	public void addMultiplicativeExpression(MultiplicativeExpression t){
		this.multiplicativeexpressions.add(t);
	}
	public void visit(){
		if(coz==0){
			//"multiplicativeExpression ( plusOrMinus multiplicativeExpression)*";
			add(this.multiplicativeexpression);
			formats("%s %s",this.plusorminuss,this.multiplicativeexpressions);
		}
	}
}
