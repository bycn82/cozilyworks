package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class SuperSuffix extends CodeDocument{
private Arguments arguments;
public void setArguments(Arguments t){
this.arguments=t;
if(single.get("arguments")==null){single.put("arguments",arguments);}
}
private TypeArguments typearguments;
public void setTypeArguments(TypeArguments t){
this.typearguments=t;
if(single.get("typearguments")==null){single.put("typearguments",typearguments);}
}
private String identifierStr;
public void setIDENTIFIER(String t){
this.identifierStr=t;
if(single.get("identifier")==null){single.put("identifier",identifierStr);}
}
public void visit(){
if(coz==0){
format="arguments";
}
if(coz==1){
format="'.' typeArguments? IDENTIFIER arguments?";
}
}
}
