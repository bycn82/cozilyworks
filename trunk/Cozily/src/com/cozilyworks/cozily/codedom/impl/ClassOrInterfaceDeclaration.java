package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ClassOrInterfaceDeclaration extends CodeDocument{
private ClassDeclaration classdeclaration;
public void setClassDeclaration(ClassDeclaration t){
this.classdeclaration=t;
}
private InterfaceDeclaration interfacedeclaration;
public void setInterfaceDeclaration(InterfaceDeclaration t){
this.interfacedeclaration=t;
}
public void visit(){
if(coz==0){
//"classDeclaration";
add(classdeclaration);}
if(coz==1){
//"interfaceDeclaration";
add(interfacedeclaration);}
}
}
