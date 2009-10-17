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
private Expression expression;
public void setExpression(Expression t){
this.expression=t;
}
}
