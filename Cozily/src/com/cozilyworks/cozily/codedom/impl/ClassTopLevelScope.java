package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ClassTopLevelScope extends CodeDocument{
private List<ClassScopeDeclarations> classscopedeclarationss=new ArrayList<ClassScopeDeclarations>();
public void addClassScopeDeclarations(ClassScopeDeclarations t){
this.classscopedeclarationss.add(t);
}
}
