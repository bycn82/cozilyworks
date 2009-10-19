package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class IdentifierSuffix extends CodeDocument{
private List<String> bracketss=new ArrayList<String>();
public void addBRACKETS(String t){
this.bracketss.add(t);
if(multi.get("brackets")==null){multi.put("brackets",bracketss);}
}
private List<Expression> expressions=new ArrayList<Expression>();
public void addExpression(Expression t){
this.expressions.add(t);
if(multi.get("expression")==null){multi.put("expression",expressions);}
}
private Arguments arguments;
public void setArguments(Arguments t){
this.arguments=t;
if(single.get("arguments")==null){single.put("arguments",arguments);}
}
private NonWildcardTypeArguments nonwildcardtypearguments;
public void setNonWildcardTypeArguments(NonWildcardTypeArguments t){
this.nonwildcardtypearguments=t;
if(single.get("nonwildcardtypearguments")==null){single.put("nonwildcardtypearguments",nonwildcardtypearguments);}
}
private String identifierStr;
public void setIDENTIFIER(String t){
this.identifierStr=t;
if(single.get("identifier")==null){single.put("identifier",identifierStr);}
}
private InnerCreator innercreator;
public void setInnerCreator(InnerCreator t){
this.innercreator=t;
if(single.get("innercreator")==null){single.put("innercreator",innercreator);}
}
public void visit(){
if(coz==0){
format="BRACKETS+ '.' 'class'";
}
if(coz==1){
format="('[' expression ']' )+";
}
if(coz==2){
format="arguments";
}
if(coz==3){
format="'.' 'class'";
}
if(coz==4){
format="'.' nonWildcardTypeArguments IDENTIFIER arguments";
}
if(coz==5){
format="'.' 'this'";
}
if(coz==6){
format="'.' 'super' arguments";
}
if(coz==7){
format="innerCreator";
}
}
}
