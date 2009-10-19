package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class AnnotationTypeBody extends CodeDocument{
private List<AnnotationTypeElementDeclaration> annotationtypeelementdeclarations=new ArrayList<AnnotationTypeElementDeclaration>();
public void addAnnotationTypeElementDeclaration(AnnotationTypeElementDeclaration t){
this.annotationtypeelementdeclarations.add(t);
if(multi.get("annotationtypeelementdeclaration")==null){multi.put("annotationtypeelementdeclaration",annotationtypeelementdeclarations);}
}
public void visit(){
if(coz==0){
format="'{' annotationTypeElementDeclaration* '}'";
}
}
}
