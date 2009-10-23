package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class IdentifierSuffix extends CodeDocument{
private List<String> bracketss=new ArrayList<String>();
public void addBRACKETS(String t){
this.bracketss.add(t);
}
private List<Expression> expressions=new ArrayList<Expression>();
public void addExpression(Expression t){
this.expressions.add(t);
}
private Arguments arguments;
public void setArguments(Arguments t){
this.arguments=t;
}
private NonWildcardTypeArguments nonwildcardtypearguments;
public void setNonWildcardTypeArguments(NonWildcardTypeArguments t){
this.nonwildcardtypearguments=t;
}
private String identifierStr;
public void setIDENTIFIER(String t){
this.identifierStr=t;
}
private InnerCreator innercreator;
public void setInnerCreator(InnerCreator t){
this.innercreator=t;
}
public void visit(){
if(coz==0){
//"BRACKETS+ '.' 'class'";
}
if(coz==1){
//"('[' expression ']')+";
}
if(coz==2){
//"arguments";
add(arguments);}
if(coz==3){
//"'.' 'class'";
}
if(coz==4){
//"'.' nonWildcardTypeArguments IDENTIFIER arguments";
}
if(coz==5){
//"'.' 'this'";
}
if(coz==6){
//"'.' 'super' arguments";
}
if(coz==7){
//"innerCreator";
add(innercreator);}
}
}
