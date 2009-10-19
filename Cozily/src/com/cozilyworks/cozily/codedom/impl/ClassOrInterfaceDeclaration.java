package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ClassOrInterfaceDeclaration extends CodeDocument{
private ClassDeclaration classdeclaration;
public void setClassDeclaration(ClassDeclaration t){
this.classdeclaration=t;
if(single.get("classdeclaration")==null){single.put("classdeclaration",classdeclaration);}
}
private InterfaceDeclaration interfacedeclaration;
public void setInterfaceDeclaration(InterfaceDeclaration t){
this.interfacedeclaration=t;
if(single.get("interfacedeclaration")==null){single.put("interfacedeclaration",interfacedeclaration);}
}
public void visit(){
if(coz==0){
format="classDeclaration";
}
if(coz==1){
format="interfaceDeclaration";
}
}
}
