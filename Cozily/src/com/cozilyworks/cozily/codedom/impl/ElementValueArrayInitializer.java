package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ElementValueArrayInitializer extends CodeDocument{
	private ElementValue elementvalue;
	public void setElementValue(ElementValue t){
		this.elementvalue=t;
	}
	private List<ElementValue> elementvalues=new ArrayList<ElementValue>();
	public void addElementValue(ElementValue t){
		this.elementvalues.add(t);
	}
	private String commaStr;
	public void setCOMMA(String t){
		this.commaStr=t;
	}
	public void visit(){
		if(coz==0){
			// "'{'(elementValue  (',' elementValue)*  )? COMMA? '}'";
			add("{");
			add(this.elementvalue);
			adds(", %s",this.elementvalues);
			add(this.commaStr);
			add("}");
		}
	}
}
