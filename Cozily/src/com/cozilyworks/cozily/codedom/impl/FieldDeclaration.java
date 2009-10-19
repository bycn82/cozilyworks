package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class FieldDeclaration extends CodeDocument{
private Modifiers modifiers;
public void setModifiers(Modifiers t){
this.modifiers=t;
if(single.get("modifiers")==null){single.put("modifiers",modifiers);}
}
private Type type;
public void setType(Type t){
this.type=t;
if(single.get("type")==null){single.put("type",type);}
}
private VariableDeclarator variabledeclarator;
public void setVariableDeclarator(VariableDeclarator t){
this.variabledeclarator=t;
if(single.get("variabledeclarator")==null){single.put("variabledeclarator",variabledeclarator);}
}
private List<VariableDeclarator> variabledeclarators=new ArrayList<VariableDeclarator>();
public void addVariableDeclarator(VariableDeclarator t){
this.variabledeclarators.add(t);
if(multi.get("variabledeclarator")==null){multi.put("variabledeclarator",variabledeclarators);}
}
public void visit(){
if(coz==0){
format="modifiers type variableDeclarator (',' variableDeclarator)* ';'";
}
}
}
