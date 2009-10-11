package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class NewArrayConstruction extends CodeDocument{
private ArrayDeclaratorList arraydeclaratorlist1;
public void setArrayDeclaratorList(ArrayDeclaratorList t){
this.arraydeclaratorlist1=t;
}
private ArrayInitializer arrayinitializer2;
public void setArrayInitializer(ArrayInitializer t){
this.arrayinitializer2=t;
}
private List<Expression> expressions=new ArrayList<Expression>();
public void addExpression(Expression t){
this.expressions.add(t);
}
}
