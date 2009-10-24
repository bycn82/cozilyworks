package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class SwitchLabel extends CodeDocument{
	private Expression expression;
	public void setExpression(Expression t){
		this.expression=t;
	}
	public void visit(){
		if(coz==0){
			//"'case' expression ':'";
			format("case %s :",this.expression);
		}
		if(coz==1){
			//"'default' ':'";
			add("default:");
		}
	}
}
