package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class Annotation extends CodeDocument{
private String string1;
public void setAT(String t){
this.string1=t;
}
private QualifiedIdentifier qualifiedidentifier2;
public void setQualifiedIdentifier(QualifiedIdentifier t){
this.qualifiedidentifier2=t;
}
private AnnotationInit annotationinit3;
public void setAnnotationInit(AnnotationInit t){
this.annotationinit3=t;
}
}
