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
	private List<ClassTopLevelScope> classtoplevelscopes=new ArrayList<ClassTopLevelScope>();
	public void addClassTopLevelScope(ClassTopLevelScope t){
		this.classtoplevelscopes.add(t);
	}
	private String interfaceStr;
	public void setINTERFACE(String t){
		this.interfaceStr=t;
	}
	private InterfaceTopLevelScope interfacetoplevelscope9;
	public void setInterfaceTopLevelScope(InterfaceTopLevelScope t){
		this.interfacetoplevelscope9=t;
	}
	private String enumStr;
	public void setENUM(String t){
		this.enumStr=t;
	}
	private EnumTopLevelScope enumtoplevelscope11;
	public void setEnumTopLevelScope(EnumTopLevelScope t){
		this.enumtoplevelscope11=t;
	}
	private String atStr;
	public void setAT(String t){
		this.atStr=t;
	}
	private AnnotationTopLevelScope annotationtoplevelscope13;
	public void setAnnotationTopLevelScope(AnnotationTopLevelScope t){
		this.annotationtoplevelscope13=t;
	}
	public void visit(){
		if(this.classStr!=null){
			add(this.modifierlist2);
			b();
			add(this.classStr);
			b();
			add(this.id);
			b();
			add(this.generictypeparameterlist4);
			b();
			add(this.extendsclause5);
			b();
			add(this.implementsclause6);
			b();
			add("{");
			add(N);
			for(ClassTopLevelScope clzToplevelscope:this.classtoplevelscopes){
				add(clzToplevelscope);
			}
			add("}");
		}
		if(this.interfaceStr!=null){
		}
		if(this.enumStr!=null){
		}
		if(this.atStr!=null){
		}
	}
}
