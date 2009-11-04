package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class ElementValuePair extends CodeDocument{
	public String identifierStr;
	public void setIDENTIFIER(String t){
		this.identifierStr=t;
	}
	public ElementValue elementvalue;
	public void setElementValue(ElementValue t){
		this.elementvalue=t;
	}
	public void visit(){
		if(coz==0){
			//"IDENTIFIER '=' elementValue";
			format("%s = %s",this.identifierStr,this.elementvalue);
		}
	}
}
