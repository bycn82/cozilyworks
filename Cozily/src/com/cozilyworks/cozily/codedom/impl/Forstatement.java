package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class Forstatement extends CodeDocument{
private VariableModifiers variablemodifiers;
public void setVariableModifiers(VariableModifiers t){
this.variablemodifiers=t;
}
private Type type;
public void setType(Type t){
this.type=t;
}
private String identifierStr;
public void setIDENTIFIER(String t){
this.identifierStr=t;
}
private Expression expression;
public void setExpression(Expression t){
this.expression=t;
}
private Statement statement;
public void setStatement(Statement t){
this.statement=t;
}
private ForInit forinit;
public void setForInit(ForInit t){
this.forinit=t;
}
private ExpressionList expressionlist;
public void setExpressionList(ExpressionList t){
this.expressionlist=t;
}
}
