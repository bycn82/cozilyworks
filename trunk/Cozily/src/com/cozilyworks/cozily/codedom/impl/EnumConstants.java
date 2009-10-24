package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class EnumConstants extends CodeDocument{
	private EnumConstant enumconstant;
	public void setEnumConstant(EnumConstant t){
		this.enumconstant=t;
	}
	private List<EnumConstant> enumconstants=new ArrayList<EnumConstant>();
	public void addEnumConstant(EnumConstant t){
		this.enumconstants.add(t);
	}
	public void visit(){
		if(coz==0){
			//"enumConstant (',' enumConstant)*";
			add(this.enumconstant);
			formats(", %s",this.enumconstants);
		}
	}
}
