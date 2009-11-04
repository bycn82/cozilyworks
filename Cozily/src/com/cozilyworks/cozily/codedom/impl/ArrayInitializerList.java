package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class ArrayInitializerList extends CodeDocument{
	public VariableInitializer variableinitializer;
	public void setVariableInitializer(VariableInitializer t){
		this.variableinitializer=t;
	}
	public List<VariableInitializer> variableinitializers=new ArrayList<VariableInitializer>();
	public void addVariableInitializer(VariableInitializer t){
		this.variableinitializers.add(t);
	}
	public void visit(){
		if(coz==0){
			//"variableInitializer (',' variableInitializer)*";
			add(this.variableinitializer);
			adds(", %s",this.variableinitializers);
		}
	}
}
