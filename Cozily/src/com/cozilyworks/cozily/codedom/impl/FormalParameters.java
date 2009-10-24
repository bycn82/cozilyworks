package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class FormalParameters extends CodeDocument{
	private FormalParameterDecls formalparameterdecls;
	public void setFormalParameterDecls(FormalParameterDecls t){
		this.formalparameterdecls=t;
	}
	public void visit(){
		if(coz==0){
			//"'(' formalParameterDecls? ')'";
			format("( %s )",this.formalparameterdecls);
		}
	}
}
