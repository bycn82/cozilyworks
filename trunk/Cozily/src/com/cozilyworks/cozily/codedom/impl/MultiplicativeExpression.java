package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class MultiplicativeExpression extends CodeDocument{
	private UnaryExpression unaryexpression;
	public void setUnaryExpression(UnaryExpression t){
		this.unaryexpression=t;
	}
	private List<TimesDivide> timesdivides=new ArrayList<TimesDivide>();
	public void addTimesDivide(TimesDivide t){
		this.timesdivides.add(t);
	}
	private List<UnaryExpression> unaryexpressions=new ArrayList<UnaryExpression>();
	public void addUnaryExpression(UnaryExpression t){
		this.unaryexpressions.add(t);
	}
	public void visit(){
		add(this.unaryexpression);
		for(int i=0;i<this.timesdivides.size();i++){
			add(this.timesdivides.get(i));
			add(this.unaryexpressions.get(i));
		}
	}
}
