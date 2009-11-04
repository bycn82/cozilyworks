package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class VariableModifiers extends CodeDocument{
	public List<FinalOrAnno> finalorannos=new ArrayList<FinalOrAnno>();
	public void addFinalOrAnno(FinalOrAnno t){
		this.finalorannos.add(t);
	}
	public void visit(){
		if(coz==0){
			//"finalOrAnno*";
			adds(this.finalorannos);
		}
	}
}
