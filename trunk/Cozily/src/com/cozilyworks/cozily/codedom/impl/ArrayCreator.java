package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ArrayCreator extends CodeDocument{
private CreatedName createdname;
public void setCreatedName(CreatedName t){
this.createdname=t;
}
private List<String> bracketss=new ArrayList<String>();
public void addBRACKETS(String t){
this.bracketss.add(t);
}
private ArrayInitializer arrayinitializer;
public void setArrayInitializer(ArrayInitializer t){
this.arrayinitializer=t;
}
private List<Expression> expressions=new ArrayList<Expression>();
public void addExpression(Expression t){
this.expressions.add(t);
}
public void visit(){
if(coz==0){
//"'new' createdName BRACKETS+ arrayInitializer";
}
if(coz==1){
//"'new' createdName ('[' expression ']')+ BRACKETS*";
}
}
}
