package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class CastExpression extends CodeDocument{
private PrimitiveType primitivetype;
public void setPrimitiveType(PrimitiveType t){
this.primitivetype=t;
if(single.get("primitivetype")==null){single.put("primitivetype",primitivetype);}
}
private UnaryExpression unaryexpression;
public void setUnaryExpression(UnaryExpression t){
this.unaryexpression=t;
if(single.get("unaryexpression")==null){single.put("unaryexpression",unaryexpression);}
}
private Type type;
public void setType(Type t){
this.type=t;
if(single.get("type")==null){single.put("type",type);}
}
private UnaryExpressionNotPlusMinus unaryexpressionnotplusminus;
public void setUnaryExpressionNotPlusMinus(UnaryExpressionNotPlusMinus t){
this.unaryexpressionnotplusminus=t;
if(single.get("unaryexpressionnotplusminus")==null){single.put("unaryexpressionnotplusminus",unaryexpressionnotplusminus);}
}
public void visit(){
if(coz==0){
format="'(' primitiveType ')' unaryExpression";
}
if(coz==1){
format="'(' type ')' unaryExpressionNotPlusMinus";
}
}
}
