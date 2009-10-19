package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class UnaryExpression extends CodeDocument{
private UnaryExpression unaryexpression;
public void setUnaryExpression(UnaryExpression t){
this.unaryexpression=t;
if(single.get("unaryexpression")==null){single.put("unaryexpression",unaryexpression);}
}
private UnaryExpressionNotPlusMinus unaryexpressionnotplusminus;
public void setUnaryExpressionNotPlusMinus(UnaryExpressionNotPlusMinus t){
this.unaryexpressionnotplusminus=t;
if(single.get("unaryexpressionnotplusminus")==null){single.put("unaryexpressionnotplusminus",unaryexpressionnotplusminus);}
}
public void visit(){
if(coz==0){
format="'+'  unaryExpression";
}
if(coz==1){
format="'-' unaryExpression";
}
if(coz==2){
format="'++' unaryExpression";
}
if(coz==3){
format="'--' unaryExpression";
}
if(coz==4){
format="unaryExpressionNotPlusMinus";
}
}
}
