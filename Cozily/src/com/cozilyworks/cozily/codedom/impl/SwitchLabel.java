package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class SwitchLabel extends CodeDocument{
private String caseStr;
public void setCASE(String t){
this.caseStr=t;
}
private Expression expression;
public void setExpression(Expression t){
this.expression=t;
}
private String defaultStr;
public void setDEFAULT(String t){
this.defaultStr=t;
}
public void visit(){
if(coz==0){
//"CASE expression ':'";
}
if(coz==1){
//"DEFAULT ':'";
}
}
}
