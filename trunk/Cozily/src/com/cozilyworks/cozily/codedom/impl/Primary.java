package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class Primary extends CodeDocument{
private ParExpression parexpression;
public void setParExpression(ParExpression t){
this.parexpression=t;
if(single.get("parexpression")==null){single.put("parexpression",parexpression);}
}
private List<String> identifiers=new ArrayList<String>();
public void addIDENTIFIER(String t){
this.identifiers.add(t);
if(multi.get("identifier")==null){multi.put("identifier",identifiers);}
}
private IdentifierSuffix identifiersuffix;
public void setIdentifierSuffix(IdentifierSuffix t){
this.identifiersuffix=t;
if(single.get("identifiersuffix")==null){single.put("identifiersuffix",identifiersuffix);}
}
private String identifierStr;
public void setIDENTIFIER(String t){
this.identifierStr=t;
if(single.get("identifier")==null){single.put("identifier",identifierStr);}
}
private SuperSuffix supersuffix;
public void setSuperSuffix(SuperSuffix t){
this.supersuffix=t;
if(single.get("supersuffix")==null){single.put("supersuffix",supersuffix);}
}
private Literal literal;
public void setLiteral(Literal t){
this.literal=t;
if(single.get("literal")==null){single.put("literal",literal);}
}
private Creator creator;
public void setCreator(Creator t){
this.creator=t;
if(single.get("creator")==null){single.put("creator",creator);}
}
private PrimitiveType primitivetype;
public void setPrimitiveType(PrimitiveType t){
this.primitivetype=t;
if(single.get("primitivetype")==null){single.put("primitivetype",primitivetype);}
}
private List<String> bracketss=new ArrayList<String>();
public void addBRACKETS(String t){
this.bracketss.add(t);
if(multi.get("brackets")==null){multi.put("brackets",bracketss);}
}
public void visit(){
if(coz==0){
format="parExpression";
}
if(coz==1){
format="'this' ('.' IDENTIFIER)* identifierSuffix?";
}
if(coz==2){
format="IDENTIFIER ('.' IDENTIFIER)* identifierSuffix?";
}
if(coz==3){
format="'super' superSuffix";
}
if(coz==4){
format="literal";
}
if(coz==5){
format="creator";
}
if(coz==6){
format="primitiveType (BRACKETS)* '.' 'class'";
}
if(coz==7){
format="'void' '.' 'class'";
}
}
}
