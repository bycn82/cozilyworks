package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class AdditiveExpression extends CodeDocument{
	private MultiplicativeExpression multiplicativeexpression;
	public void setMultiplicativeExpression(MultiplicativeExpression t){
		this.multiplicativeexpression=t;
	}
	private List<PlusOrMinus> plusorminuss=new ArrayList<PlusOrMinus>();
	public void addPlusOrMinus(PlusOrMinus t){
		this.plusorminuss.add(t);
	}
	private List<MultiplicativeExpression> multiplicativeexpressions=new ArrayList<MultiplicativeExpression>();
	public void addMultiplicativeExpression(MultiplicativeExpression t){
		this.multiplicativeexpressions.add(t);
	}
	public void visit(){
		add(this.multiplicativeexpression);
		for(int i=0;i<this.plusorminuss.size();i++){
			add(this.plusorminuss.get(i));
			add(this.multiplicativeexpressions.get(i));
		}
	}
}