package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class TypeParameters extends CodeDocument{
	public TypeParameter typeparameter;
	public void setTypeParameter(TypeParameter t){
		this.typeparameter=t;
	}
	public List<TypeParameter> typeparameters=new ArrayList<TypeParameter>();
	public void addTypeParameter(TypeParameter t){
		this.typeparameters.add(t);
	}
	public void visit(){
		if(coz==0){
			//"'<' typeParameter (',' typeParameter)* '>'";
			add("<");
			add(this.typeparameter);
			adds(", %s",this.typeparameters);
			add(">");
		}
	}
}
