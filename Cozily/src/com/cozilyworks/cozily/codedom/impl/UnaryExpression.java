package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class UnaryExpression extends CodeDocument{
	private UnaryExpression unaryexpression;
	public void setUnaryExpression(UnaryExpression t){
		this.unaryexpression=t;
	}
	private UnaryExpressionNotPlusMinus unaryexpressionnotplusminus;
	public void setUnaryExpressionNotPlusMinus(UnaryExpressionNotPlusMinus t){
		this.unaryexpressionnotplusminus=t;
	}
	public void visit(){
		if(coz==0){
			//"'+'  unaryExpression";
			add("+");
			add(this.unaryexpression);
		}
		if(coz==1){
			//"'-' unaryExpression";
			add("-");
			add(this.unaryexpression);
		}
		if(coz==2){
			//"'++' unaryExpression";
			add("++");
			add(this.unaryexpression);
		}
		if(coz==3){
			//"'--' unaryExpression";
			add("--");
			add(this.unaryexpression);
		}
		if(coz==4){
			//"unaryExpressionNotPlusMinus";
			add(unaryexpressionnotplusminus);
		}
	}
}
