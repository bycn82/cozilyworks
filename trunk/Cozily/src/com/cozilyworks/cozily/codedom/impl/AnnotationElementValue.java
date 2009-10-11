package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class AnnotationElementValue extends CodeDocument{
private List<AnnotationElementValue> annotationelementvalues=new ArrayList<AnnotationElementValue>();
public void addAnnotationElementValue(AnnotationElementValue t){
this.annotationelementvalues.add(t);
}
private Annotation annotation2;
public void setAnnotation(Annotation t){
this.annotation2=t;
}
private Expression expression3;
public void setExpression(Expression t){
this.expression3=t;
}
}
