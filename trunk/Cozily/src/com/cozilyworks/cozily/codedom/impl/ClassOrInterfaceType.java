package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ClassOrInterfaceType extends CodeDocument{
private String identifierStr;
public void setIDENTIFIER(String t){
this.identifierStr=t;
if(single.get("identifier")==null){single.put("identifier",identifierStr);}
}
private TypeArguments typearguments;
public void setTypeArguments(TypeArguments t){
this.typearguments=t;
if(single.get("typearguments")==null){single.put("typearguments",typearguments);}
}
private List<String> identifiers=new ArrayList<String>();
public void addIDENTIFIER(String t){
this.identifiers.add(t);
if(multi.get("identifier")==null){multi.put("identifier",identifiers);}
}
private List<TypeArguments> typeargumentss=new ArrayList<TypeArguments>();
public void addTypeArguments(TypeArguments t){
this.typeargumentss.add(t);
if(multi.get("typearguments")==null){multi.put("typearguments",typeargumentss);}
}
public void visit(){
if(coz==0){
format="IDENTIFIER typeArguments? ('.' IDENTIFIER typeArguments? )*";
}
}
}
