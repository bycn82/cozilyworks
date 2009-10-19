package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class InterfaceDeclaration extends CodeDocument{
private NormalInterfaceDeclaration normalinterfacedeclaration;
public void setNormalInterfaceDeclaration(NormalInterfaceDeclaration t){
this.normalinterfacedeclaration=t;
if(single.get("normalinterfacedeclaration")==null){single.put("normalinterfacedeclaration",normalinterfacedeclaration);}
}
private AnnotationTypeDeclaration annotationtypedeclaration;
public void setAnnotationTypeDeclaration(AnnotationTypeDeclaration t){
this.annotationtypedeclaration=t;
if(single.get("annotationtypedeclaration")==null){single.put("annotationtypedeclaration",annotationtypedeclaration);}
}
public void visit(){
if(coz==0){
format="normalInterfaceDeclaration";
}
if(coz==1){
format="annotationTypeDeclaration";
}
}
}
