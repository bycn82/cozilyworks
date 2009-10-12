package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class PackageDeclaration extends CodeDocument{
	private String pkg;
	public void setPACKAGE(String t){
		this.pkg=t;
	}
	private QualifiedIdentifier id;
	public void setQualifiedIdentifier(QualifiedIdentifier t){
		this.id=t;
	}
	public void visit(){
		add(pkg);
		b();
		add(id);
		add(SEMIN);
	}
}
