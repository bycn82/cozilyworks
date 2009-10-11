package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class AnnotationInitializers extends CodeDocument{
private List<AnnotationInitializer> annotationinitializers=new ArrayList<AnnotationInitializer>();
public void addAnnotationInitializer(AnnotationInitializer t){
this.annotationinitializers.add(t);
}
private AnnotationElementValue annotationelementvalue2;
public void setAnnotationElementValue(AnnotationElementValue t){
this.annotationelementvalue2=t;
}
}
