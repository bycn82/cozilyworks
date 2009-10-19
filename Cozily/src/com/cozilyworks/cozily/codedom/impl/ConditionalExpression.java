package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ConditionalExpression extends CodeDocument{
private ConditionalOrExpression conditionalorexpression;
public void setConditionalOrExpression(ConditionalOrExpression t){
this.conditionalorexpression=t;
if(single.get("conditionalorexpression")==null){single.put("conditionalorexpression",conditionalorexpression);}
}
private Expression expression;
public void setExpression(Expression t){
this.expression=t;
if(single.get("expression")==null){single.put("expression",expression);}
}
private ConditionalExpression conditionalexpression;
public void setConditionalExpression(ConditionalExpression t){
this.conditionalexpression=t;
if(single.get("conditionalexpression")==null){single.put("conditionalexpression",conditionalexpression);}
}
public void visit(){
if(coz==0){
format="conditionalOrExpression ('?' expression ':' conditionalExpression)?";
}
}
}
