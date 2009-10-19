package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ClassDeclaration extends CodeDocument{
private NormalClassDeclaration normalclassdeclaration;
public void setNormalClassDeclaration(NormalClassDeclaration t){
this.normalclassdeclaration=t;
if(single.get("normalclassdeclaration")==null){single.put("normalclassdeclaration",normalclassdeclaration);}
}
private EnumDeclaration enumdeclaration;
public void setEnumDeclaration(EnumDeclaration t){
this.enumdeclaration=t;
if(single.get("enumdeclaration")==null){single.put("enumdeclaration",enumdeclaration);}
}
public void visit(){
if(coz==0){
format="normalClassDeclaration";
}
if(coz==1){
format="enumDeclaration";
}
}
}
