package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ForInit extends CodeDocument{
private LocalVariableDeclaration localvariabledeclaration;
public void setLocalVariableDeclaration(LocalVariableDeclaration t){
this.localvariabledeclaration=t;
}
private ExpressionList expressionlist;
public void setExpressionList(ExpressionList t){
this.expressionlist=t;
}
}
