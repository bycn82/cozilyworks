package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class LocalVariableDeclaration extends CodeDocument{
private VariableModifiers variablemodifiers;
public void setVariableModifiers(VariableModifiers t){
this.variablemodifiers=t;
if(single.get("variablemodifiers")==null){single.put("variablemodifiers",variablemodifiers);}
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
format="variableModifiers type variableDeclarator (',' variableDeclarator)*";
}
}
}
