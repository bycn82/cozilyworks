package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class InterfaceMethodDeclaration extends CodeDocument{
private Modifiers modifiers;
public void setModifiers(Modifiers t){
this.modifiers=t;
if(single.get("modifiers")==null){single.put("modifiers",modifiers);}
}
private TypeParameters typeparameters;
public void setTypeParameters(TypeParameters t){
this.typeparameters=t;
if(single.get("typeparameters")==null){single.put("typeparameters",typeparameters);}
}
private ReturnType returntype;
public void setReturnType(ReturnType t){
this.returntype=t;
if(single.get("returntype")==null){single.put("returntype",returntype);}
}
private String identifierStr;
public void setIDENTIFIER(String t){
this.identifierStr=t;
if(single.get("identifier")==null){single.put("identifier",identifierStr);}
}
private FormalParameters formalparameters;
public void setFormalParameters(FormalParameters t){
this.formalparameters=t;
if(single.get("formalparameters")==null){single.put("formalparameters",formalparameters);}
}
private List<String> bracketss=new ArrayList<String>();
public void addBRACKETS(String t){
this.bracketss.add(t);
if(multi.get("brackets")==null){multi.put("brackets",bracketss);}
}
private QualifiedNameList qualifiednamelist;
public void setQualifiedNameList(QualifiedNameList t){
this.qualifiednamelist=t;
if(single.get("qualifiednamelist")==null){single.put("qualifiednamelist",qualifiednamelist);}
}
public void visit(){
if(coz==0){
format="modifiers typeParameters? returnType IDENTIFIER formalParameters BRACKETS* ('throws' qualifiedNameList)? ';'";
}
}
}
