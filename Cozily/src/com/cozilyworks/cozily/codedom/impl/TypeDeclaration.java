package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class TypeDeclaration extends CodeDocument{
	private String classStr;
	public void setCLASS(String t){
		this.classStr=t;
	}
	private ModifierList modifierlist2;
	public void setModifierList(ModifierList t){
		this.modifierlist2=t;
	}
	private String id;
	public void setIDENT(String t){
		this.id=t;
	}
	private GenericTypeParameterList generictypeparameterlist4;
	public void setGenericTypeParameterList(GenericTypeParameterList t){
		this.generictypeparameterlist4=t;
	}
	private ExtendsClause extendsclause5;
	public void setExtendsClause(ExtendsClause t){
		this.extendsclause5=t;
	}
	private ImplementsClause implementsclause6;
	public void setImplementsClause(ImplementsClause t){
		this.implementsclause6=t;
	}
	private ClassTopLevelScope classtoplevelscope7;
	public void setClassTopLevelScope(ClassTopLevelScope t){
		this.classtoplevelscope7=t;
	}
	private String string8;
	public void setINTERFACE(String t){
		this.string8=t;
	}
	private InterfaceTopLevelScope interfacetoplevelscope9;
	public void setInterfaceTopLevelScope(InterfaceTopLevelScope t){
		this.interfacetoplevelscope9=t;
	}
	private String string10;
	public void setENUM(String t){
		this.string10=t;
	}
	private EnumTopLevelScope enumtoplevelscope11;
	public void setEnumTopLevelScope(EnumTopLevelScope t){
		this.enumtoplevelscope11=t;
	}
	private String string12;
	public void setAT(String t){
		this.string12=t;
	}
	private AnnotationTopLevelScope annotationtoplevelscope13;
	public void setAnnotationTopLevelScope(AnnotationTopLevelScope t){
		this.annotationtoplevelscope13=t;
	}
}
