package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class RelationalExpression extends CodeDocument{
	private ShiftExpression shiftexpression;
	public void setShiftExpression(ShiftExpression t){
		this.shiftexpression=t;
	}
	private List<RelationalOp> relationalops=new ArrayList<RelationalOp>();
	public void addRelationalOp(RelationalOp t){
		this.relationalops.add(t);
	}
	private List<ShiftExpression> shiftexpressions=new ArrayList<ShiftExpression>();
	public void addShiftExpression(ShiftExpression t){
		this.shiftexpressions.add(t);
	}
	public void visit(){
		add(this.shiftexpression);
		for(RelationalOp relationalop:this.relationalops){
			add(relationalop);
		}
		for(ShiftExpression shiftexp:this.shiftexpressions){
			add(shiftexp);
		}
	}
}
