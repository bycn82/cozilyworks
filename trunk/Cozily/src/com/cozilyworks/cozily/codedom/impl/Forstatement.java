package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class Forstatement extends CodeDocument{
private VariableModifiers variablemodifiers;
public void setVariableModifiers(VariableModifiers t){
this.variablemodifiers=t;
if(single.get("variablemodifiers")==null){single.put("variablemodifiers",variablemodifiers);}
}
private Type type;
public void setType(Type t){
this.type=t;
if(single.get("type")==null){single.put("type",type);}
}
private String identifierStr;
public void setIDENTIFIER(String t){
this.identifierStr=t;
if(single.get("identifier")==null){single.put("identifier",identifierStr);}
}
private Expression expression;
public void setExpression(Expression t){
this.expression=t;
if(single.get("expression")==null){single.put("expression",expression);}
}
private Statement statement;
public void setStatement(Statement t){
this.statement=t;
if(single.get("statement")==null){single.put("statement",statement);}
}
private ForInit forinit;
public void setForInit(ForInit t){
this.forinit=t;
if(single.get("forinit")==null){single.put("forinit",forinit);}
}
private ExpressionList expressionlist;
public void setExpressionList(ExpressionList t){
this.expressionlist=t;
if(single.get("expressionlist")==null){single.put("expressionlist",expressionlist);}
}
public void visit(){
if(coz==0){
format="'for' '(' variableModifiers type IDENTIFIER ':' expression ')' statement";
}
if(coz==1){
format="'for' '(' forInit? ';' expression? ';' expressionList? ')' statement";
}
}
}
