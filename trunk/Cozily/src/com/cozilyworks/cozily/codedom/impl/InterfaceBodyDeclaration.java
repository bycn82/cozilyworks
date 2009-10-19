package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class InterfaceBodyDeclaration extends CodeDocument{
private InterfaceFieldDeclaration interfacefielddeclaration;
public void setInterfaceFieldDeclaration(InterfaceFieldDeclaration t){
this.interfacefielddeclaration=t;
if(single.get("interfacefielddeclaration")==null){single.put("interfacefielddeclaration",interfacefielddeclaration);}
}
private InterfaceMethodDeclaration interfacemethoddeclaration;
public void setInterfaceMethodDeclaration(InterfaceMethodDeclaration t){
this.interfacemethoddeclaration=t;
if(single.get("interfacemethoddeclaration")==null){single.put("interfacemethoddeclaration",interfacemethoddeclaration);}
}
private InterfaceDeclaration interfacedeclaration;
public void setInterfaceDeclaration(InterfaceDeclaration t){
this.interfacedeclaration=t;
if(single.get("interfacedeclaration")==null){single.put("interfacedeclaration",interfacedeclaration);}
}
private ClassDeclaration classdeclaration;
public void setClassDeclaration(ClassDeclaration t){
this.classdeclaration=t;
if(single.get("classdeclaration")==null){single.put("classdeclaration",classdeclaration);}
}
private String semiStr;
public void setSEMI(String t){
this.semiStr=t;
if(single.get("semi")==null){single.put("semi",semiStr);}
}
public void visit(){
if(coz==0){
format="interfaceFieldDeclaration";
}
if(coz==1){
format="interfaceMethodDeclaration";
}
if(coz==2){
format="interfaceDeclaration";
}
if(coz==3){
format="classDeclaration";
}
if(coz==4){
format="SEMI";
}
}
}
