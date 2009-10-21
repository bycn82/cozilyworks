package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class UnaryExpression extends CodeDocument{
private UnaryExpression unaryexpression;
public void setUnaryExpression(UnaryExpression t){
this.unaryexpression=t;
}
private UnaryExpressionNotPlusMinus unaryexpressionnotplusminus;
public void setUnaryExpressionNotPlusMinus(UnaryExpressionNotPlusMinus t){
this.unaryexpressionnotplusminus=t;
}
public void visit(){
if(coz==0){
//"'+'  unaryExpression";
}
if(coz==1){
//"'-' unaryExpression";
}
if(coz==2){
//"'++' unaryExpression";
}
if(coz==3){
//"'--' unaryExpression";
}
if(coz==4){
//"unaryExpressionNotPlusMinus";
add(unaryexpressionnotplusminus);}
}
}
