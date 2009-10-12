package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class TypeIdent extends CodeDocument{
	private String string1;
	public void setIDENT(String t){
		this.string1=t;
	}
	private GenericTypeArgumentList generictypeargumentlist2;
	public void setGenericTypeArgumentList(GenericTypeArgumentList t){
		this.generictypeargumentlist2=t;
	}
	public void visit(){
		add(this.string1);
		add(this.generictypeargumentlist2);
	}
}
