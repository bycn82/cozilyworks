package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class FinalOrAnno extends CodeDocument{
	public Annotation annotation;
	public void setAnnotation(Annotation t){
		this.annotation=t;
	}
	public void visit(){
		if(coz==0){
			//"'final'";
			add("final");
		}
		if(coz==1){
			//"annotation";
			add(annotation);
		}
	}
}
