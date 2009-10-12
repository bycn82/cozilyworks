package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class Type extends CodeDocument{
	private PrimitiveType primitivetype1;
	public void setPrimitiveType(PrimitiveType t){
		this.primitivetype1=t;
	}
	private QualifiedTypeIdent qualifiedtypeident2;
	public void setQualifiedTypeIdent(QualifiedTypeIdent t){
		this.qualifiedtypeident2=t;
	}
	private ArrayDeclaratorList arraydeclaratorlist3;
	public void setArrayDeclaratorList(ArrayDeclaratorList t){
		this.arraydeclaratorlist3=t;
	}
	public void visit(){
		add(this.primitivetype1);
		add(this.arraydeclaratorlist3);
		add(this.qualifiedtypeident2);
	}
}
