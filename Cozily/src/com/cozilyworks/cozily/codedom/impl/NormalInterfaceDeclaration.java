package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class NormalInterfaceDeclaration extends CodeDocument{
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
private TypeList typelist;
public void setTypeList(TypeList t){
this.typelist=t;
if(single.get("typelist")==null){single.put("typelist",typelist);}
}
private InterfaceBody interfacebody;
public void setInterfaceBody(InterfaceBody t){
this.interfacebody=t;
if(single.get("interfacebody")==null){single.put("interfacebody",interfacebody);}
}
public void visit(){
if(coz==0){
format="modifiers 'interface' IDENTIFIER typeParameters?  ('extends' typeList)? interfaceBody";
}
}
}
