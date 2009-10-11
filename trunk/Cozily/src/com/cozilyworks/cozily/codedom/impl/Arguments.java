package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class Arguments extends CodeDocument{
private List<Expression> expressions=new ArrayList<Expression>();
public void addExpression(Expression t){
this.expressions.add(t);
}
}
