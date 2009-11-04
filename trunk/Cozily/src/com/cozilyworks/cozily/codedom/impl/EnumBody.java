package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class EnumBody extends CodeDocument{
	public EnumConstants enumconstants;
	public void setEnumConstants(EnumConstants t){
		this.enumconstants=t;
	}
	public String commaStr;
	public void setCOMMA(String t){
		this.commaStr=t;
	}
	public EnumBodyDeclarations enumbodydeclarations;
	public void setEnumBodyDeclarations(EnumBodyDeclarations t){
		this.enumbodydeclarations=t;
	}
	public void visit(){
		if(coz==0){
			//"'{' enumConstants? COMMA? enumBodyDeclarations? '}'";
			format("{ %s %s %s }",this.enumconstants,this.commaStr,this.enumbodydeclarations);
		}
	}
}
