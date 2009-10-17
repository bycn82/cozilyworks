package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import com.cozilyworks.cozily.codedom.*;

public class ConditionalOrExpression extends CodeDocument{
	private ConditionalAndExpression conditionalandexpression;
	public void setConditionalAndExpression(ConditionalAndExpression t){
		this.conditionalandexpression=t;
	}
	private List<ConditionalAndExpression> conditionalandexpressions=new ArrayList<ConditionalAndExpression>();
	public void addConditionalAndExpression(ConditionalAndExpression t){
		this.conditionalandexpressions.add(t);
	}
	public void visit(){
		if(coz==0){
			add(this.conditionalandexpression);
			add(StringUtils.join(this.conditionalandexpressions,"||"));
		}
	}
}
