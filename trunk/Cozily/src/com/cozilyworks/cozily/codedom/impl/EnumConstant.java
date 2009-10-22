package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class EnumConstant extends CodeDocument{
	private Annotations annotations;
	public void setAnnotations(Annotations t){
		this.annotations=t;
	}
	private String identifierStr;
	public void setIDENTIFIER(String t){
		this.identifierStr=t;
	}
	private Arguments arguments;
	public void setArguments(Arguments t){
		this.arguments=t;
	}
	private ClassBody classbody;
	public void setClassBody(ClassBody t){
		this.classbody=t;
	}
	public void visit(){
		if(coz==0){
			// "annotations? IDENTIFIER arguments? classBody?";
			format("%s %s %s %s",this.annotations,this.identifierStr,this.arguments,this.classbody);
		}
	}
}
