package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class InstanceOfExpression extends CodeDocument{
	public RelationalExpression relationalexpression;
	public void setRelationalExpression(RelationalExpression t){
		this.relationalexpression=t;
	}
	public Type type;
	public void setType(Type t){
		this.type=t;
	}
	public void visit(){
		if(coz==0){
			//"relationalExpression ('instanceof' type)?";
			add(this.relationalexpression);
			add("instanceof %s",this.type);
		}
	}
}
