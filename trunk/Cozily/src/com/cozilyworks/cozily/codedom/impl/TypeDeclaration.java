package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class TypeDeclaration extends CodeDocument{
private ClassOrInterfaceDeclaration classorinterfacedeclaration;
public void setClassOrInterfaceDeclaration(ClassOrInterfaceDeclaration t){
this.classorinterfacedeclaration=t;
if(single.get("classorinterfacedeclaration")==null){single.put("classorinterfacedeclaration",classorinterfacedeclaration);}
}
public void visit(){
if(coz==0){
format="classOrInterfaceDeclaration";
}
}
}
