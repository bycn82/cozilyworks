package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class BlockStatement extends CodeDocument{
private LocalVariableDeclaration localvariabledeclaration1;
public void setLocalVariableDeclaration(LocalVariableDeclaration t){
this.localvariabledeclaration1=t;
}
private TypeDeclaration typedeclaration2;
public void setTypeDeclaration(TypeDeclaration t){
this.typedeclaration2=t;
}
private Statement statement3;
public void setStatement(Statement t){
this.statement3=t;
}
}
