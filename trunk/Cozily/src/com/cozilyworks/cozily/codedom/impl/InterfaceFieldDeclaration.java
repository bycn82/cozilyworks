package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class InterfaceFieldDeclaration extends CodeDocument{
private Modifiers modifiers;
public void setModifiers(Modifiers t){
this.modifiers=t;
}
private Type type;
public void setType(Type t){
this.type=t;
}
private VariableDeclarator variabledeclarator;
public void setVariableDeclarator(VariableDeclarator t){
this.variabledeclarator=t;
}
private List<VariableDeclarator> variabledeclarators=new ArrayList<VariableDeclarator>();
public void addVariableDeclarator(VariableDeclarator t){
this.variabledeclarators.add(t);
}
}
