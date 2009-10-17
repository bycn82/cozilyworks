package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import com.cozilyworks.cozily.codedom.*;

public class EqualityExpression extends CodeDocument{
	private InstanceOfExpression instanceofexpression;
	public void setInstanceOfExpression(InstanceOfExpression t){
		this.instanceofexpression=t;
	}
	private List<EqualOrNotequal> equalornotequals=new ArrayList<EqualOrNotequal>();
	public void addEqualOrNotequal(EqualOrNotequal t){
		this.equalornotequals.add(t);
	}
	private List<InstanceOfExpression> instanceofexpressions=new ArrayList<InstanceOfExpression>();
	public void addInstanceOfExpression(InstanceOfExpression t){
		this.instanceofexpressions.add(t);
	}
	public void visit(){
		if(coz==0){
			add(this.instanceofexpression);
			for(EqualOrNotequal equalornot:this.equalornotequals){
				add(equalornot);
			}
			for(InstanceOfExpression instantofexp:this.instanceofexpressions){
				add(instantofexp);
			}
		}
	}
}
