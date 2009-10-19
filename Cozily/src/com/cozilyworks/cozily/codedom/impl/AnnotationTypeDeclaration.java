package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class AnnotationTypeDeclaration extends CodeDocument{
private Modifiers modifiers;
public void setModifiers(Modifiers t){
this.modifiers=t;
if(single.get("modifiers")==null){single.put("modifiers",modifiers);}
}
private String identifierStr;
public void setIDENTIFIER(String t){
this.identifierStr=t;
if(single.get("identifier")==null){single.put("identifier",identifierStr);}
}
private AnnotationTypeBody annotationtypebody;
public void setAnnotationTypeBody(AnnotationTypeBody t){
this.annotationtypebody=t;
if(single.get("annotationtypebody")==null){single.put("annotationtypebody",annotationtypebody);}
}
public void visit(){
if(coz==0){
format="modifiers '@' 'interface' IDENTIFIER annotationTypeBody";
}
}
}
