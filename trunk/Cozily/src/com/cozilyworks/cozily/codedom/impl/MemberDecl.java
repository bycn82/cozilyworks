package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class MemberDecl extends CodeDocument{
private FieldDeclaration fielddeclaration;
public void setFieldDeclaration(FieldDeclaration t){
this.fielddeclaration=t;
if(single.get("fielddeclaration")==null){single.put("fielddeclaration",fielddeclaration);}
}
private MethodDeclaration methoddeclaration;
public void setMethodDeclaration(MethodDeclaration t){
this.methoddeclaration=t;
if(single.get("methoddeclaration")==null){single.put("methoddeclaration",methoddeclaration);}
}
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
format="fieldDeclaration";
}
if(coz==1){
format="methodDeclaration";
}
if(coz==2){
format="classDeclaration";
}
if(coz==3){
format="interfaceDeclaration";
}
}
}
