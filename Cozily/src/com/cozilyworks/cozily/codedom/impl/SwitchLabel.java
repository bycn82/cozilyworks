package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class SwitchLabel extends CodeDocument{
private String caseStr;
public void setCASE(String t){
this.caseStr=t;
if(single.get("case")==null){single.put("case",caseStr);}
}
private Expression expression;
public void setExpression(Expression t){
this.expression=t;
if(single.get("expression")==null){single.put("expression",expression);}
}
private String defaultStr;
public void setDEFAULT(String t){
this.defaultStr=t;
if(single.get("default")==null){single.put("default",defaultStr);}
}
public void visit(){
if(coz==0){
format="CASE expression ':'";
}
if(coz==1){
format="DEFAULT ':'";
}
}
}
