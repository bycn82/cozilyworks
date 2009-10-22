package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ImportDeclaration extends CodeDocument{
	private String staticStr;
	public void setSTATIC(String t){
		this.staticStr=t;
	}
	private QualifiedName qualifiedname;
	public void setQualifiedName(QualifiedName t){
		this.qualifiedname=t;
	}
	private String dotstarStr;
	public void setDOTSTAR(String t){
		this.dotstarStr=t;
	}
	public void visit(){
		if(coz==0){
			// "'import' STATIC? qualifiedName DOTSTAR? ';'";
			format("import %s %s%s;\n",this.staticStr,this.qualifiedname,this.dotstarStr);
		}
	}
}
