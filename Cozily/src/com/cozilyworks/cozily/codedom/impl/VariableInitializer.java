package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class VariableInitializer extends CodeDocument{
private ArrayInitializer arrayinitializer;
public void setArrayInitializer(ArrayInitializer t){
this.arrayinitializer=t;
if(single.get("arrayinitializer")==null){single.put("arrayinitializer",arrayinitializer);}
}
private Expression expression;
public void setExpression(Expression t){
this.expression=t;
if(single.get("expression")==null){single.put("expression",expression);}
}
public void visit(){
if(coz==0){
format="arrayInitializer";
}
if(coz==1){
format="expression";
}
}
}
