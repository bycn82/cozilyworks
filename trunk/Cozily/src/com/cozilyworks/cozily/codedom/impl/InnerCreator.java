package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class InnerCreator extends CodeDocument{
private NonWildcardTypeArguments nonwildcardtypearguments;
public void setNonWildcardTypeArguments(NonWildcardTypeArguments t){
this.nonwildcardtypearguments=t;
}
private IdentifierArgs identifierargs;
public void setIdentifierArgs(IdentifierArgs t){
this.identifierargs=t;
}
private ClassCreatorRest classcreatorrest;
public void setClassCreatorRest(ClassCreatorRest t){
this.classcreatorrest=t;
}
public void visit(){
if(coz==0){
//"'.' 'new' nonWildcardTypeArguments? identifierArgs classCreatorRest";
}
}
}
