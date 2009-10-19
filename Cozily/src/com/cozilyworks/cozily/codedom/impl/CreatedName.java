package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class CreatedName extends CodeDocument{
private ClassOrInterfaceType classorinterfacetype;
public void setClassOrInterfaceType(ClassOrInterfaceType t){
this.classorinterfacetype=t;
if(single.get("classorinterfacetype")==null){single.put("classorinterfacetype",classorinterfacetype);}
}
private PrimitiveType primitivetype;
public void setPrimitiveType(PrimitiveType t){
this.primitivetype=t;
if(single.get("primitivetype")==null){single.put("primitivetype",primitivetype);}
}
public void visit(){
if(coz==0){
format="classOrInterfaceType";
}
if(coz==1){
format="primitiveType";
}
}
}
