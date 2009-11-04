package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class ImportDeclaration extends CodeDocument{
	public String staticStr;
	public void setSTATIC(String t){
		this.staticStr=t;
	}
	public QualifiedName qualifiedname;
	public void setQualifiedName(QualifiedName t){
		this.qualifiedname=t;
	}
	public String dotstarStr;
	public void setDOTSTAR(String t){
		this.dotstarStr=t;
	}
	public void visit(){
		if(coz==0){
			//"'import' STATIC? qualifiedName DOTSTAR? ';'";
			String importPath=this.qualifiedname.toString();
			source.addImports(importPath+(this.dotstarStr==null?"":".*"));
			format("import %s %s%s;",this.staticStr,importPath,this.dotstarStr);
		}
	}
}
