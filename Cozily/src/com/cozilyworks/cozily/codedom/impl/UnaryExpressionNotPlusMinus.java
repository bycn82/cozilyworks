package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class UnaryExpressionNotPlusMinus extends CodeDocument{
	private UnaryExpression unaryexpression;
	public void setUnaryExpression(UnaryExpression t){
		this.unaryexpression=t;
	}
	private CastExpression castexpression;
	public void setCastExpression(CastExpression t){
		this.castexpression=t;
	}
	private Primary primary;
	public void setPrimary(Primary t){
		this.primary=t;
	}
	private List<Selector> selectors=new ArrayList<Selector>();
	public void addSelector(Selector t){
		this.selectors.add(t);
	}
	private DoublePlusMinus doubleplusminus;
	public void setDoublePlusMinus(DoublePlusMinus t){
		this.doubleplusminus=t;
	}
	public void visit(){
		if(coz==0){
			// "'~' unaryExpression";
			add("~%s",this.unaryexpression);
		}
		if(coz==1){
			// "'!' unaryExpression";
			add("!%s",this.unaryexpression);
		}
		if(coz==2){
			// "castExpression";
			add(castexpression);
		}
		if(coz==3){
			// "primary selector* doublePlusMinus?";
			add(this.primary);
			adds(this.selectors);
			add(this.doubleplusminus);
		}
	}
}
