package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class ElementValueList extends CodeDocument{
	private ElementValue elementvalue;
	public void setElementValue(ElementValue t){
		this.elementvalue=t;
	}
	private List<ElementValue> elementvalues=new ArrayList<ElementValue>();
	public void addElementValue(ElementValue t){
		this.elementvalues.add(t);
	}
	public void visit(){
		if(coz==0){
			//"elementValue (',' elementValue)*";
			add(this.elementvalue);
			formats(", %s",this.elementvalues);
		}
	}
}
