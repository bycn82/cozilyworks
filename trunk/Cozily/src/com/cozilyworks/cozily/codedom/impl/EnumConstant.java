package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class EnumConstant extends CodeDocument{
	public Annotations annotations;
	public void setAnnotations(Annotations t){
		this.annotations=t;
	}
	public String identifierStr;
	public void setIDENTIFIER(String t){
		this.identifierStr=t;
	}
	public Arguments arguments;
	public void setArguments(Arguments t){
		this.arguments=t;
	}
	public ClassBody classbody;
	public void setClassBody(ClassBody t){
		this.classbody=t;
	}
	public void visit(){
		if(coz==0){
			//"annotations? IDENTIFIER arguments? classBody?";
			format("%s %s %s %s",this.annotations,this.identifierStr,this.arguments,this.classbody);
		}
	}
}
