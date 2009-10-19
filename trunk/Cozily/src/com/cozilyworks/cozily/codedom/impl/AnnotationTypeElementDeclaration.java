package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class AnnotationTypeElementDeclaration extends CodeDocument{
private AnnotationMethodDeclaration annotationmethoddeclaration;
public void setAnnotationMethodDeclaration(AnnotationMethodDeclaration t){
this.annotationmethoddeclaration=t;
if(single.get("annotationmethoddeclaration")==null){single.put("annotationmethoddeclaration",annotationmethoddeclaration);}
}
private InterfaceFieldDeclaration interfacefielddeclaration;
public void setInterfaceFieldDeclaration(InterfaceFieldDeclaration t){
this.interfacefielddeclaration=t;
if(single.get("interfacefielddeclaration")==null){single.put("interfacefielddeclaration",interfacefielddeclaration);}
}
private NormalClassDeclaration normalclassdeclaration;
public void setNormalClassDeclaration(NormalClassDeclaration t){
this.normalclassdeclaration=t;
if(single.get("normalclassdeclaration")==null){single.put("normalclassdeclaration",normalclassdeclaration);}
}
private NormalInterfaceDeclaration normalinterfacedeclaration;
public void setNormalInterfaceDeclaration(NormalInterfaceDeclaration t){
this.normalinterfacedeclaration=t;
if(single.get("normalinterfacedeclaration")==null){single.put("normalinterfacedeclaration",normalinterfacedeclaration);}
}
private EnumDeclaration enumdeclaration;
public void setEnumDeclaration(EnumDeclaration t){
this.enumdeclaration=t;
if(single.get("enumdeclaration")==null){single.put("enumdeclaration",enumdeclaration);}
}
private AnnotationTypeDeclaration annotationtypedeclaration;
public void setAnnotationTypeDeclaration(AnnotationTypeDeclaration t){
this.annotationtypedeclaration=t;
if(single.get("annotationtypedeclaration")==null){single.put("annotationtypedeclaration",annotationtypedeclaration);}
}
public void visit(){
if(coz==0){
format="annotationMethodDeclaration";
}
if(coz==1){
format="interfaceFieldDeclaration";
}
if(coz==2){
format="normalClassDeclaration";
}
if(coz==3){
format="normalInterfaceDeclaration";
}
if(coz==4){
format="enumDeclaration";
}
if(coz==5){
format="annotationTypeDeclaration";
}
if(coz==6){
format="';'";
}
}
}
