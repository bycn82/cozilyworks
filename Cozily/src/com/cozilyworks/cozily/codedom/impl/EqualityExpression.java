package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class EqualityExpression extends CodeDocument{
	public InstanceOfExpression instanceofexpression;
	public void setInstanceOfExpression(InstanceOfExpression t){
		this.instanceofexpression=t;
	}
	public List<EqOrNot> eqornots=new ArrayList<EqOrNot>();
	public void addEqOrNot(EqOrNot t){
		this.eqornots.add(t);
	}
	public List<InstanceOfExpression> instanceofexpressions=new ArrayList<InstanceOfExpression>();
	public void addInstanceOfExpression(InstanceOfExpression t){
		this.instanceofexpressions.add(t);
	}
	public void visit(){
		if(coz==0){
			//"instanceOfExpression ( eqOrNot instanceOfExpression )*";
			add(this.instanceofexpression);
			formats("%s %s",this.eqornots,this.instanceofexpressions);
		}
	}
}
