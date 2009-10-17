package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class PackageDeclaration extends CodeDocument{
	private QualifiedName qualifiedname;
	public void setQualifiedName(QualifiedName t){
		this.qualifiedname=t;
	}
	public void visit(){
		add("package "+qualifiedname+SEMIN);
	}
}
