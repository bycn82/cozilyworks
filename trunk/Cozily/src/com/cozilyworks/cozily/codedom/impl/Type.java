package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class Type extends CodeDocument{
private ClassOrInterfaceType classorinterfacetype;
public void setClassOrInterfaceType(ClassOrInterfaceType t){
this.classorinterfacetype=t;
}
private List<String> bracketss=new ArrayList<String>();
public void addBRACKETS(String t){
this.bracketss.add(t);
}
private PrimitiveType primitivetype;
public void setPrimitiveType(PrimitiveType t){
this.primitivetype=t;
}
public void visit(){
if(coz==0){
//"classOrInterfaceType BRACKETS*";
}
if(coz==1){
//"primitiveType BRACKETS*";
}
}
}
