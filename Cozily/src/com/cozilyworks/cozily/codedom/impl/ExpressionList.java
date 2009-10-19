package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ExpressionList extends CodeDocument{
private Expression expression;
public void setExpression(Expression t){
this.expression=t;
if(single.get("expression")==null){single.put("expression",expression);}
}
private List<Expression> expressions=new ArrayList<Expression>();
public void addExpression(Expression t){
this.expressions.add(t);
if(multi.get("expression")==null){multi.put("expression",expressions);}
}
public void visit(){
if(coz==0){
format="expression (',' expression)*";
}
}
}
