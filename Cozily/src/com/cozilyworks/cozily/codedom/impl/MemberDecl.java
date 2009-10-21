package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class MemberDecl extends CodeDocument{
private FieldDeclaration fielddeclaration;
public void setFieldDeclaration(FieldDeclaration t){
this.fielddeclaration=t;
}
private MethodDeclaration methoddeclaration;
public void setMethodDeclaration(MethodDeclaration t){
this.methoddeclaration=t;
}
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
//"fieldDeclaration";
}
if(coz==1){
//"methodDeclaration";
}
if(coz==2){
//"classDeclaration";
}
if(coz==3){
//"interfaceDeclaration";
}
}
}
