package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class UnaryExpressionNotPlusMinus extends CodeDocument{
	public UnaryExpression unaryexpression;
	public void setUnaryExpression(UnaryExpression t){
		this.unaryexpression=t;
	}
	public CastExpression castexpression;
	public void setCastExpression(CastExpression t){
		this.castexpression=t;
	}
	public Primary primary;
	public void setPrimary(Primary t){
		this.primary=t;
	}
	public List<Selector> selectors=new ArrayList<Selector>();
	public void addSelector(Selector t){
		this.selectors.add(t);
	}
	public PlusPlusOrMinusMinus plusplusorminusminus;
	public void setPlusPlusOrMinusMinus(PlusPlusOrMinusMinus t){
		this.plusplusorminusminus=t;
	}
	public void visit(){
		if(coz==0){
			//"'~' unaryExpression";
			add("~");
			add(this.unaryexpression);
		}
		if(coz==1){
			//"'!' unaryExpression";
			add("!");
			add(this.unaryexpression);
		}
		if(coz==2){
			//"castExpression";
			add(castexpression);
		}
		if(coz==3){
			//"primary selector* plusPlusOrMinusMinus?";
			add(primary);
			adds(selectors);
			add(this.plusplusorminusminus);
		}
	}
}
