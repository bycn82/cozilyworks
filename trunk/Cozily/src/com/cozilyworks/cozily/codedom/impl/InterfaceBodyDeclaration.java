package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class InterfaceBodyDeclaration extends CodeDocument{
private InterfaceFieldDeclaration interfacefielddeclaration;
public void setInterfaceFieldDeclaration(InterfaceFieldDeclaration t){
this.interfacefielddeclaration=t;
}
private InterfaceMethodDeclaration interfacemethoddeclaration;
public void setInterfaceMethodDeclaration(InterfaceMethodDeclaration t){
this.interfacemethoddeclaration=t;
}
private InterfaceDeclaration interfacedeclaration;
public void setInterfaceDeclaration(InterfaceDeclaration t){
this.interfacedeclaration=t;
}
private ClassDeclaration classdeclaration;
public void setClassDeclaration(ClassDeclaration t){
this.classdeclaration=t;
}
private String semiStr;
public void setSEMI(String t){
this.semiStr=t;
}
}
