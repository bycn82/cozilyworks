package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class InterfaceDeclaration extends CodeDocument{
	public NormalInterfaceDeclaration normalinterfacedeclaration;
	public void setNormalInterfaceDeclaration(NormalInterfaceDeclaration t){
		this.normalinterfacedeclaration=t;
	}
	public AnnotationTypeDeclaration annotationtypedeclaration;
	public void setAnnotationTypeDeclaration(AnnotationTypeDeclaration t){
		this.annotationtypedeclaration=t;
	}
	public void visit(){
		if(coz==0){
			//"normalInterfaceDeclaration";
			add(normalinterfacedeclaration);
		}
		if(coz==1){
			//"annotationTypeDeclaration";
			add(annotationtypedeclaration);
		}
	}
}
