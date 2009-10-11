package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class PrimaryExpression extends CodeDocument{
private String string1;
public void setDOT(String t){
this.string1=t;
}
private PrimaryExpression primaryexpression2;
public void setPrimaryExpression(PrimaryExpression t){
this.primaryexpression2=t;
}
private String string3;
public void setIDENT(String t){
this.string3=t;
}
private String string4;
public void setTHIS(String t){
this.string4=t;
}
private String string5;
public void setSUPER(String t){
this.string5=t;
}
private InnerNewExpression innernewexpression6;
public void setInnerNewExpression(InnerNewExpression t){
this.innernewexpression6=t;
}
private String string7;
public void setCLASS(String t){
this.string7=t;
}
private PrimitiveType primitivetype8;
public void setPrimitiveType(PrimitiveType t){
this.primitivetype8=t;
}
private String string9;
public void setVOID(String t){
this.string9=t;
}
private ParenthesizedExpression parenthesizedexpression10;
public void setParenthesizedExpression(ParenthesizedExpression t){
this.parenthesizedexpression10=t;
}
private GenericTypeArgumentList generictypeargumentlist11;
public void setGenericTypeArgumentList(GenericTypeArgumentList t){
this.generictypeargumentlist11=t;
}
private Arguments arguments12;
public void setArguments(Arguments t){
this.arguments12=t;
}
private ExplicitConstructorCall explicitconstructorcall13;
public void setExplicitConstructorCall(ExplicitConstructorCall t){
this.explicitconstructorcall13=t;
}
private Expression expression14;
public void setExpression(Expression t){
this.expression14=t;
}
private Literal literal15;
public void setLiteral(Literal t){
this.literal15=t;
}
private NewExpression newexpression16;
public void setNewExpression(NewExpression t){
this.newexpression16=t;
}
private ArrayTypeDeclarator arraytypedeclarator17;
public void setArrayTypeDeclarator(ArrayTypeDeclarator t){
this.arraytypedeclarator17=t;
}
}
