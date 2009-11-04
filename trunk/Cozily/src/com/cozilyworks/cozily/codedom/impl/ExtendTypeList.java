package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class ExtendTypeList extends CodeDocument{
	public TypeList typelist;
	public void setTypeList(TypeList x0){
		this.typelist=x0;
	}
	public void visit(){
		if(coz==0){
			//'extends' typeList
			add("extends %s",this.typelist);
		}
	}
}
