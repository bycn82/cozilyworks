package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class Annotation extends CodeDocument{
	private QualifiedName qualifiedname;
	public void setQualifiedName(QualifiedName t){
		this.qualifiedname=t;
	}
	private ElementValueOrPairs elementvalueorpairs;
	public void setElementValueOrPairs(ElementValueOrPairs t){
		this.elementvalueorpairs=t;
	}
	public void visit(){
		if(coz==0){
			//"'@' qualifiedName ('(' elementValueOrPairs? ')' )?";
			add("@ %s",this.qualifiedname);
			format("( %s )",this.elementvalueorpairs);
		}
	}
}
