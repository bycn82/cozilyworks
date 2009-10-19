package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class MethodDeclaration extends CodeDocument{
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
private QualifiedNameList qualifiednamelist;
public void setQualifiedNameList(QualifiedNameList t){
this.qualifiednamelist=t;
if(single.get("qualifiednamelist")==null){single.put("qualifiednamelist",qualifiednamelist);}
}
private ExplicitConstructorInvocation explicitconstructorinvocation;
public void setExplicitConstructorInvocation(ExplicitConstructorInvocation t){
this.explicitconstructorinvocation=t;
if(single.get("explicitconstructorinvocation")==null){single.put("explicitconstructorinvocation",explicitconstructorinvocation);}
}
private List<BlockStatement> blockstatements=new ArrayList<BlockStatement>();
public void addBlockStatement(BlockStatement t){
this.blockstatements.add(t);
if(multi.get("blockstatement")==null){multi.put("blockstatement",blockstatements);}
}
private ReturnType returntype;
public void setReturnType(ReturnType t){
this.returntype=t;
if(single.get("returntype")==null){single.put("returntype",returntype);}
}
private List<String> bracketss=new ArrayList<String>();
public void addBRACKETS(String t){
this.bracketss.add(t);
if(multi.get("brackets")==null){multi.put("brackets",bracketss);}
}
private BlockOrComma blockorcomma;
public void setBlockOrComma(BlockOrComma t){
this.blockorcomma=t;
if(single.get("blockorcomma")==null){single.put("blockorcomma",blockorcomma);}
}
public void visit(){
if(coz==0){
format="modifiers typeParameters? IDENTIFIER formalParameters ('throws' qualifiedNameList)? '{' explicitConstructorInvocation? blockStatement* '}'";
}
if(coz==1){
format="modifiers typeParameters? returnType IDENTIFIER formalParameters BRACKETS* ('throws' qualifiedNameList)? blockOrComma";
}
}
}
