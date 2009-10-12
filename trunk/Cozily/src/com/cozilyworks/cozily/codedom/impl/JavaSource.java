package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class JavaSource extends CodeDocument{
	private AnnotationList annotationlist1;
	public void setAnnotationList(AnnotationList t){
		this.annotationlist1=t;
	}
	private PackageDeclaration packageDec;
	public void setPackageDeclaration(PackageDeclaration t){
		this.packageDec=t;
	}
	private List<ImportDeclaration> importdeclarations=new ArrayList<ImportDeclaration>();
	public void addImportDeclaration(ImportDeclaration t){
		this.importdeclarations.add(t);
	}
	private List<TypeDeclaration> typedeclarations=new ArrayList<TypeDeclaration>();
	public void addTypeDeclaration(TypeDeclaration t){
		this.typedeclarations.add(t);
	}
	public void visit(){
		if(this.packageDec!=null){
			add(this.packageDec.toString());
		}
		if(this.importdeclarations!=null){
			for(ImportDeclaration importDec:this.importdeclarations){
				add(importDec);
			}
		}
		if(this.typedeclarations!=null){
			for(TypeDeclaration typeDec:this.typedeclarations){
				add(typeDec);
			}
		}
	}
}
