package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ArrayCreator extends CodeDocument{
private CreatedName createdname;
public void setCreatedName(CreatedName t){
this.createdname=t;
if(single.get("createdname")==null){single.put("createdname",createdname);}
}
private List<String> bracketss=new ArrayList<String>();
public void addBRACKETS(String t){
this.bracketss.add(t);
if(multi.get("brackets")==null){multi.put("brackets",bracketss);}
}
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
private List<Expression> expressions=new ArrayList<Expression>();
public void addExpression(Expression t){
this.expressions.add(t);
if(multi.get("expression")==null){multi.put("expression",expressions);}
}
public void visit(){
if(coz==0){
format="'new' createdName BRACKETS+ arrayInitializer";
}
if(coz==1){
format="'new' createdName '[' expression ']' (   '[' expression ']')* BRACKETS*";
}
}
}
