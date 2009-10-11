package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class NewExpression extends CodeDocument{
private PrimitiveType primitivetype1;
public void setPrimitiveType(PrimitiveType t){
this.primitivetype1=t;
}
private NewArrayConstruction newarrayconstruction2;
public void setNewArrayConstruction(NewArrayConstruction t){
this.newarrayconstruction2=t;
}
private GenericTypeArgumentList generictypeargumentlist3;
public void setGenericTypeArgumentList(GenericTypeArgumentList t){
this.generictypeargumentlist3=t;
}
private QualifiedTypeIdent qualifiedtypeident4;
public void setQualifiedTypeIdent(QualifiedTypeIdent t){
this.qualifiedtypeident4=t;
}
private Arguments arguments5;
public void setArguments(Arguments t){
this.arguments5=t;
}
private ClassTopLevelScope classtoplevelscope6;
public void setClassTopLevelScope(ClassTopLevelScope t){
this.classtoplevelscope6=t;
}
}
