package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class NormalClassDeclaration extends CodeDocument{
private Modifiers modifiers;
public void setModifiers(Modifiers t){
this.modifiers=t;
if(single.get("modifiers")==null){single.put("modifiers",modifiers);}
}
private String identifierStr;
public void setIDENTIFIER(String t){
this.identifierStr=t;
if(single.get("identifier")==null){single.put("identifier",identifierStr);}
}
private TypeParameters typeparameters;
public void setTypeParameters(TypeParameters t){
this.typeparameters=t;
if(single.get("typeparameters")==null){single.put("typeparameters",typeparameters);}
}
private Type type;
public void setType(Type t){
this.type=t;
if(single.get("type")==null){single.put("type",type);}
}
private TypeList typelist;
public void setTypeList(TypeList t){
this.typelist=t;
if(single.get("typelist")==null){single.put("typelist",typelist);}
}
private ClassBody classbody;
public void setClassBody(ClassBody t){
this.classbody=t;
if(single.get("classbody")==null){single.put("classbody",classbody);}
}
public void visit(){
if(coz==0){
format="modifiers  'class' IDENTIFIER typeParameters? ('extends' type)? ('implements' typeList)? classBody";
}
}
}
