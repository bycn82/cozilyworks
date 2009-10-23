package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class AnnotationMethodDeclaration extends CodeDocument{
private Modifiers modifiers;
public void setModifiers(Modifiers t){
this.modifiers=t;
}
private Type type;
public void setType(Type t){
this.type=t;
}
private String identifierStr;
public void setIDENTIFIER(String t){
this.identifierStr=t;
}
private ElementValue elementvalue;
public void setElementValue(ElementValue t){
this.elementvalue=t;
}
public void visit(){
if(coz==0){
//"modifiers type IDENTIFIER '(' ')' ('default' elementValue)? ';'";
}
}
}
