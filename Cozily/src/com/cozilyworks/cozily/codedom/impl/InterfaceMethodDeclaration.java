package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class InterfaceMethodDeclaration extends CodeDocument{
private Modifiers modifiers;
public void setModifiers(Modifiers t){
this.modifiers=t;
}
private TypeParameters typeparameters;
public void setTypeParameters(TypeParameters t){
this.typeparameters=t;
}
private ReturnType returntype;
public void setReturnType(ReturnType t){
this.returntype=t;
}
private String identifierStr;
public void setIDENTIFIER(String t){
this.identifierStr=t;
}
private FormalParameters formalparameters;
public void setFormalParameters(FormalParameters t){
this.formalparameters=t;
}
private List<String> bracketss=new ArrayList<String>();
public void addBRACKETS(String t){
this.bracketss.add(t);
}
private QualifiedNameList qualifiednamelist;
public void setQualifiedNameList(QualifiedNameList t){
this.qualifiednamelist=t;
}
public void visit(){
if(coz==0){
//"modifiers typeParameters? returnType IDENTIFIER formalParameters BRACKETS* ('throws' qualifiedNameList)? ';'";
}
}
}
