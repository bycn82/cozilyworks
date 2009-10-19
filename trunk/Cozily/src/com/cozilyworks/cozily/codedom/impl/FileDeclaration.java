package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class FileDeclaration extends CodeDocument{
	private Annotations annotations;
	public void setAnnotations(Annotations t){
		this.annotations=t;
		if(single.get("annotations")==null){
			single.put("annotations",annotations);
		}
	}
	private PackageDeclaration packagedeclaration;
	public void setPackageDeclaration(PackageDeclaration t){
		this.packagedeclaration=t;
		if(single.get("packagedeclaration")==null){
			single.put("packagedeclaration",packagedeclaration);
		}
	}
	private List<ImportDeclaration> importdeclarations=new ArrayList<ImportDeclaration>();
	public void addImportDeclaration(ImportDeclaration t){
		this.importdeclarations.add(t);
		if(multi.get("importdeclaration")==null){
			multi.put("importdeclaration",importdeclarations);
		}
	}
	private List<TypeDeclaration> typedeclarations=new ArrayList<TypeDeclaration>();
	public void addTypeDeclaration(TypeDeclaration t){
		this.typedeclarations.add(t);
		if(multi.get("typedeclaration")==null){
			multi.put("typedeclaration",typedeclarations);
		}
	}
	public void visit(){
		if(coz==0){
			format="(annotations? packageDeclaration)? importDeclaration* typeDeclaration*";
		}
	}
}
