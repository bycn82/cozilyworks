package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class TypeList extends CodeDocument{
	private Type type;
	public void setType(Type t){
		this.type=t;
	}
	private List<Type> types=new ArrayList<Type>();
	public void addType(Type t){
		this.types.add(t);
	}
	public void visit(){
		if(coz==0){
			// "type (',' type)*";
			add(this.type);
			adds(", %s",this.types);
		}
	}
}
