package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class ElementValue extends CodeDocument{
	public ConditionalExpression conditionalexpression;
	public void setConditionalExpression(ConditionalExpression t){
		this.conditionalexpression=t;
	}
	public Annotation annotation;
	public void setAnnotation(Annotation t){
		this.annotation=t;
	}
	public ElementValueArrayInitializer elementvaluearrayinitializer;
	public void setElementValueArrayInitializer(ElementValueArrayInitializer t){
		this.elementvaluearrayinitializer=t;
	}
	public void visit(){
		if(coz==0){
			//"conditionalExpression";
			add(conditionalexpression);
		}
		if(coz==1){
			//"annotation";
			add(annotation);
		}
		if(coz==2){
			//"elementValueArrayInitializer";
			add(elementvaluearrayinitializer);
		}
	}
}
