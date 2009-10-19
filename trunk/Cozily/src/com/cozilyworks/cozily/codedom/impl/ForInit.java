package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ForInit extends CodeDocument{
private LocalVariableDeclaration localvariabledeclaration;
public void setLocalVariableDeclaration(LocalVariableDeclaration t){
this.localvariabledeclaration=t;
if(single.get("localvariabledeclaration")==null){single.put("localvariabledeclaration",localvariabledeclaration);}
}
private ExpressionList expressionlist;
public void setExpressionList(ExpressionList t){
this.expressionlist=t;
if(single.get("expressionlist")==null){single.put("expressionlist",expressionlist);}
}
public void visit(){
if(coz==0){
format="localVariableDeclaration";
}
if(coz==1){
format="expressionList";
}
}
}
