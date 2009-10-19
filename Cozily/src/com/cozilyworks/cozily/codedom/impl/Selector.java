package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class Selector extends CodeDocument{
private String identifierStr;
public void setIDENTIFIER(String t){
this.identifierStr=t;
if(single.get("identifier")==null){single.put("identifier",identifierStr);}
}
private Arguments arguments;
public void setArguments(Arguments t){
this.arguments=t;
if(single.get("arguments")==null){single.put("arguments",arguments);}
}
private SuperSuffix supersuffix;
public void setSuperSuffix(SuperSuffix t){
this.supersuffix=t;
if(single.get("supersuffix")==null){single.put("supersuffix",supersuffix);}
}
private InnerCreator innercreator;
public void setInnerCreator(InnerCreator t){
this.innercreator=t;
if(single.get("innercreator")==null){single.put("innercreator",innercreator);}
}
private Expression expression;
public void setExpression(Expression t){
this.expression=t;
if(single.get("expression")==null){single.put("expression",expression);}
}
public void visit(){
if(coz==0){
format="'.' IDENTIFIER arguments?";
}
if(coz==1){
format="'.' 'this'";
}
if(coz==2){
format="'.' 'super' superSuffix";
}
if(coz==3){
format="innerCreator";
}
if(coz==4){
format="'[' expression ']'";
}
}
}
