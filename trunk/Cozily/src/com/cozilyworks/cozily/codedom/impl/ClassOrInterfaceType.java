package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class ClassOrInterfaceType extends CodeDocument{
	private IdentifierArgs identifierargs;
	public void setIdentifierArgs(IdentifierArgs t){
		this.identifierargs=t;
	}
	private List<IdentifierArgs> identifierargss=new ArrayList<IdentifierArgs>();
	public void addIdentifierArgs(IdentifierArgs t){
		this.identifierargss.add(t);
	}
	public void visit(){
		if(coz==0){
			//"identifierArgs ('.' identifierArgs )*";
			add(this.identifierargs);
			formats(". %s",this.identifierargss);
		}
	}
}
