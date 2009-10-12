package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class QualifiedTypeIdent extends CodeDocument{
	private List<TypeIdent> typeidents=new ArrayList<TypeIdent>();
	public void addTypeIdent(TypeIdent t){
		this.typeidents.add(t);
	}
	public void visit(){
		for(TypeIdent typeId:this.typeidents){
			add(typeId);
		}
	}
}
