package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class InnerCreator extends CodeDocument{
private NonWildcardTypeArguments nonwildcardtypearguments;
public void setNonWildcardTypeArguments(NonWildcardTypeArguments t){
this.nonwildcardtypearguments=t;
if(single.get("nonwildcardtypearguments")==null){single.put("nonwildcardtypearguments",nonwildcardtypearguments);}
}
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
private ClassCreatorRest classcreatorrest;
public void setClassCreatorRest(ClassCreatorRest t){
this.classcreatorrest=t;
if(single.get("classcreatorrest")==null){single.put("classcreatorrest",classcreatorrest);}
}
public void visit(){
if(coz==0){
format="'.' 'new' nonWildcardTypeArguments? IDENTIFIER typeArguments?  classCreatorRest";
}
}
}
