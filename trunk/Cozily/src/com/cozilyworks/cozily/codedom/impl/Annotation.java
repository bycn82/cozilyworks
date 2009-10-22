package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class Annotation extends CodeDocument{
	private QualifiedName qualifiedname;
	public void setQualifiedName(QualifiedName t){
		this.qualifiedname=t;
	}
	private ElementOfAnno elementofanno;
	public void setElementOfAnno(ElementOfAnno t){
		this.elementofanno=t;
	}
	public void visit(){
		if(coz==0){
			// "'@' qualifiedName (   '(' elementOfAnno?  ')' )?";
			format("@%s(%s)",this.qualifiedname,this.elementofanno);
		}
	}
}
