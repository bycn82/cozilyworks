package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ForInit extends CodeDocument{
private LocalVariableDeclaration localvariabledeclaration1;
public void setLocalVariableDeclaration(LocalVariableDeclaration t){
this.localvariabledeclaration1=t;
}
private List<Expression> expressions=new ArrayList<Expression>();
public void addExpression(Expression t){
this.expressions.add(t);
}
}
