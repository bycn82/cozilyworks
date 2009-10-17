package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ElementValue extends CodeDocument{
private ConditionalExpression conditionalexpression;
public void setConditionalExpression(ConditionalExpression t){
this.conditionalexpression=t;
}
private Annotation annotation;
public void setAnnotation(Annotation t){
this.annotation=t;
}
private ElementValueArrayInitializer elementvaluearrayinitializer;
public void setElementValueArrayInitializer(ElementValueArrayInitializer t){
this.elementvaluearrayinitializer=t;
}
}
