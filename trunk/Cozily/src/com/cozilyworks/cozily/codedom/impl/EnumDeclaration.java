package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class EnumDeclaration extends CodeDocument{
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
private TypeList typelist;
public void setTypeList(TypeList t){
this.typelist=t;
if(single.get("typelist")==null){single.put("typelist",typelist);}
}
private EnumBody enumbody;
public void setEnumBody(EnumBody t){
this.enumbody=t;
if(single.get("enumbody")==null){single.put("enumbody",enumbody);}
}
public void visit(){
if(coz==0){
format="modifiers 'enum' IDENTIFIER ('implements' typeList)? enumBody";
}
}
}
