package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class AnnotationTopLevelScope extends CodeDocument{
private List<AnnotationScopeDeclarations> annotationscopedeclarationss=new ArrayList<AnnotationScopeDeclarations>();
public void addAnnotationScopeDeclarations(AnnotationScopeDeclarations t){
this.annotationscopedeclarationss.add(t);
}
}
