package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class Arguments extends CodeDocument{
private ExpressionList expressionlist;
public void setExpressionList(ExpressionList t){
this.expressionlist=t;
if(single.get("expressionlist")==null){single.put("expressionlist",expressionlist);}
}
public void visit(){
if(coz==0){
format="'(' expressionList? ')'";
}
}
}
