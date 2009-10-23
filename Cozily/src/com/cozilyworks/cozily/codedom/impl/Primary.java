package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class Primary extends CodeDocument{
private ParExpression parexpression;
public void setParExpression(ParExpression t){
this.parexpression=t;
}
private List<String> identifiers=new ArrayList<String>();
public void addIDENTIFIER(String t){
this.identifiers.add(t);
}
private IdentifierSuffix identifiersuffix;
public void setIdentifierSuffix(IdentifierSuffix t){
this.identifiersuffix=t;
}
private String identifierStr;
public void setIDENTIFIER(String t){
this.identifierStr=t;
}
private SuperSuffix supersuffix;
public void setSuperSuffix(SuperSuffix t){
this.supersuffix=t;
}
private Literal literal;
public void setLiteral(Literal t){
this.literal=t;
}
private Creator creator;
public void setCreator(Creator t){
this.creator=t;
}
private PrimitiveType primitivetype;
public void setPrimitiveType(PrimitiveType t){
this.primitivetype=t;
}
private List<String> bracketss=new ArrayList<String>();
public void addBRACKETS(String t){
this.bracketss.add(t);
}
public void visit(){
if(coz==0){
//"parExpression";
add(parexpression);}
if(coz==1){
//"'this' ('.' IDENTIFIER )* identifierSuffix?";
}
if(coz==2){
//"IDENTIFIER ('.' IDENTIFIER)* identifierSuffix?";
}
if(coz==3){
//"'super' superSuffix";
}
if(coz==4){
//"literal";
add(literal);}
if(coz==5){
//"creator";
add(creator);}
if(coz==6){
//"primitiveType BRACKETS* '.' 'class'";
}
if(coz==7){
//"'void' '.' 'class'";
}
}
}
