package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class TypeArgument extends CodeDocument{
	private Type type;
	public void setType(Type t){
		this.type=t;
	}
	private ExtendsOrSuper extendsorsuper;
	public void setExtendsOrSuper(ExtendsOrSuper t){
		this.extendsorsuper=t;
	}
	public void visit(){
		if(coz==0){
			//"type";
			add(type);
		}
		if(coz==1){
			//"'?' (extendsOrSuper type )?";
			format("? %s %s",this.extendsorsuper,this.type);
		}
	}
}
