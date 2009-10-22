package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class InnerCreator extends CodeDocument{
	private NonWildcardTypeArguments nonwildcardtypearguments;
	public void setNonWildcardTypeArguments(NonWildcardTypeArguments t){
		this.nonwildcardtypearguments=t;
	}
	private String identifierStr;
	public void setIDENTIFIER(String t){
		this.identifierStr=t;
	}
	private TypeArguments typearguments;
	public void setTypeArguments(TypeArguments t){
		this.typearguments=t;
	}
	private ClassCreatorRest classcreatorrest;
	public void setClassCreatorRest(ClassCreatorRest t){
		this.classcreatorrest=t;
	}
	public void visit(){
		if(coz==0){
			// "'.' 'new' nonWildcardTypeArguments? IDENTIFIER typeArguments?  classCreatorRest";
			format(".new %s %s %s %s",this.nonwildcardtypearguments,this.identifierStr,this.typearguments,
					this.classcreatorrest);
		}
	}
}
