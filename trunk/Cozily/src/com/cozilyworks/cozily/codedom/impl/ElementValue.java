package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ElementValue extends CodeDocument{
private ConditionalExpression conditionalexpression;
public void setConditionalExpression(ConditionalExpression t){
this.conditionalexpression=t;
if(single.get("conditionalexpression")==null){single.put("conditionalexpression",conditionalexpression);}
}
private Annotation annotation;
public void setAnnotation(Annotation t){
this.annotation=t;
if(single.get("annotation")==null){single.put("annotation",annotation);}
}
private ElementValueArrayInitializer elementvaluearrayinitializer;
public void setElementValueArrayInitializer(ElementValueArrayInitializer t){
this.elementvaluearrayinitializer=t;
if(single.get("elementvaluearrayinitializer")==null){single.put("elementvaluearrayinitializer",elementvaluearrayinitializer);}
}
public void visit(){
if(coz==0){
format="conditionalExpression";
}
if(coz==1){
format="annotation";
}
if(coz==2){
format="elementValueArrayInitializer";
}
}
}
