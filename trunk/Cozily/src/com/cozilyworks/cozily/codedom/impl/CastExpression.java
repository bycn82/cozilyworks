package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class CastExpression extends CodeDocument{
private PrimitiveType primitivetype;
public void setPrimitiveType(PrimitiveType t){
this.primitivetype=t;
}
private UnaryExpression unaryexpression;
public void setUnaryExpression(UnaryExpression t){
this.unaryexpression=t;
}
private Type type;
public void setType(Type t){
this.type=t;
}
private UnaryExpressionNotPlusMinus unaryexpressionnotplusminus;
public void setUnaryExpressionNotPlusMinus(UnaryExpressionNotPlusMinus t){
this.unaryexpressionnotplusminus=t;
}
}
