package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class BlockStatement extends CodeDocument{
private LocalVariableDeclarationStatement localvariabledeclarationstatement;
public void setLocalVariableDeclarationStatement(LocalVariableDeclarationStatement t){
this.localvariabledeclarationstatement=t;
}
private ClassOrInterfaceDeclaration classorinterfacedeclaration;
public void setClassOrInterfaceDeclaration(ClassOrInterfaceDeclaration t){
this.classorinterfacedeclaration=t;
}
private Statement statement;
public void setStatement(Statement t){
this.statement=t;
}
public void visit(){
if(coz==0){
//"localVariableDeclarationStatement";
}
if(coz==1){
//"classOrInterfaceDeclaration";
}
if(coz==2){
//"statement";
}
}
}
