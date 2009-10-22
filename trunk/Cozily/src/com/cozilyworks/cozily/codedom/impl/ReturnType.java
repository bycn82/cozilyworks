package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ReturnType extends CodeDocument{
	private Type type;
	public void setType(Type t){
		this.type=t;
	}
	private String voidStr;
	public void setVOID(String t){
		this.voidStr=t;
	}
	public void visit(){
		if(coz==0){
			// "type";
			add(type);
		}
		if(coz==1){
			// "VOID";
			add(voidStr);
		}
	}
}
