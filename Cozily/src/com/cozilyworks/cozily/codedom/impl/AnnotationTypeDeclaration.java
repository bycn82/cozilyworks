package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class AnnotationTypeDeclaration extends CodeDocument{
	public Modifiers modifiers;
	public void setModifiers(Modifiers t){
		this.modifiers=t;
	}
	public String identifierStr;
	public void setIDENTIFIER(String t){
		this.identifierStr=t;
	}
	public AnnotationTypeBody annotationtypebody;
	public void setAnnotationTypeBody(AnnotationTypeBody t){
		this.annotationtypebody=t;
	}
	public void visit(){
		if(coz==0){
			//"modifiers '@' 'interface' IDENTIFIER annotationTypeBody";
			format("%s @interface %s %s",this.modifiers,this.identifierStr,this.annotationtypebody);
		}
	}
}
