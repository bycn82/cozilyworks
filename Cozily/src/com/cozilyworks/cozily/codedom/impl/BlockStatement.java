package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class BlockStatement extends CodeDocument{
private LocalVariableDeclarationStatement localvariabledeclarationstatement;
public void setLocalVariableDeclarationStatement(LocalVariableDeclarationStatement t){
this.localvariabledeclarationstatement=t;
if(single.get("localvariabledeclarationstatement")==null){single.put("localvariabledeclarationstatement",localvariabledeclarationstatement);}
}
private ClassOrInterfaceDeclaration classorinterfacedeclaration;
public void setClassOrInterfaceDeclaration(ClassOrInterfaceDeclaration t){
this.classorinterfacedeclaration=t;
if(single.get("classorinterfacedeclaration")==null){single.put("classorinterfacedeclaration",classorinterfacedeclaration);}
}
private Statement statement;
public void setStatement(Statement t){
this.statement=t;
if(single.get("statement")==null){single.put("statement",statement);}
}
public void visit(){
if(coz==0){
format="localVariableDeclarationStatement";
}
if(coz==1){
format="classOrInterfaceDeclaration";
}
if(coz==2){
format="statement";
}
}
}
