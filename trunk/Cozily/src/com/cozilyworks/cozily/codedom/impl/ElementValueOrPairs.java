package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class ElementValueOrPairs extends CodeDocument{
	public ElementValuePairs elementvaluepairs;
	public void setElementValuePairs(ElementValuePairs t){
		this.elementvaluepairs=t;
	}
	public ElementValue elementvalue;
	public void setElementValue(ElementValue t){
		this.elementvalue=t;
	}
	public void visit(){
		if(coz==0){
			//"elementValuePairs";
			add(elementvaluepairs);
		}
		if(coz==1){
			//"elementValue";
			add(elementvalue);
		}
	}
}
