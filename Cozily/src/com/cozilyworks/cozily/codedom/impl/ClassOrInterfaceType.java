package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ClassOrInterfaceType extends CodeDocument{
	private String identifierStr;
	public void setIDENTIFIER(String t){
		this.identifierStr=t;
	}
	private TypeArguments typearguments;
	public void setTypeArguments(TypeArguments t){
		this.typearguments=t;
	}
	private List<String> identifiers=new ArrayList<String>();
	public void addIDENTIFIER(String t){
		this.identifiers.add(t);
	}
	private List<TypeArguments> typeargumentss=new ArrayList<TypeArguments>();
	public void addTypeArguments(TypeArguments t){
		this.typeargumentss.add(t);
	}
	public void visit(){
		if(coz==0){
			// "IDENTIFIER typeArguments? ('.' IDENTIFIER typeArguments? )*";
			format("%s %s",this.identifierStr,this.typearguments);
			formats(".%s %s",this.identifiers,this.typeargumentss);
		}
	}
}
