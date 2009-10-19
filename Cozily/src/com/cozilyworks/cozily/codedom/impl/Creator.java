package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class Creator extends CodeDocument{
private NonWildcardTypeArguments nonwildcardtypearguments;
public void setNonWildcardTypeArguments(NonWildcardTypeArguments t){
this.nonwildcardtypearguments=t;
if(single.get("nonwildcardtypearguments")==null){single.put("nonwildcardtypearguments",nonwildcardtypearguments);}
}
private ClassOrInterfaceType classorinterfacetype;
public void setClassOrInterfaceType(ClassOrInterfaceType t){
this.classorinterfacetype=t;
if(single.get("classorinterfacetype")==null){single.put("classorinterfacetype",classorinterfacetype);}
}
private ClassCreatorRest classcreatorrest;
public void setClassCreatorRest(ClassCreatorRest t){
this.classcreatorrest=t;
if(single.get("classcreatorrest")==null){single.put("classcreatorrest",classcreatorrest);}
}
private ArrayCreator arraycreator;
public void setArrayCreator(ArrayCreator t){
this.arraycreator=t;
if(single.get("arraycreator")==null){single.put("arraycreator",arraycreator);}
}
public void visit(){
if(coz==0){
format="'new' nonWildcardTypeArguments classOrInterfaceType classCreatorRest";
}
if(coz==1){
format="'new' classOrInterfaceType classCreatorRest";
}
if(coz==2){
format="arrayCreator";
}
}
}
