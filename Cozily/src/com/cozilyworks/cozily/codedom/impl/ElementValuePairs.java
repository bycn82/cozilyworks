package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ElementValuePairs extends CodeDocument{
	private ElementValuePair elementvaluepair;
	public void setElementValuePair(ElementValuePair t){
		this.elementvaluepair=t;
	}
	private List<ElementValuePair> elementvaluepairs=new ArrayList<ElementValuePair>();
	public void addElementValuePair(ElementValuePair t){
		this.elementvaluepairs.add(t);
	}
	public void visit(){
		if(coz==0){
			// "elementValuePair (',' elementValuePair)*";
			add(this.elementvaluepair);
			adds(", %",this.elementvaluepairs);
		}
	}
}
