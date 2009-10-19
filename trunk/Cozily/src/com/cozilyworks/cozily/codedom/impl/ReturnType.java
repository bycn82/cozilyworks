package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ReturnType extends CodeDocument{
private Type type;
public void setType(Type t){
this.type=t;
if(single.get("type")==null){single.put("type",type);}
}
private String voidStr;
public void setVOID(String t){
this.voidStr=t;
if(single.get("void")==null){single.put("void",voidStr);}
}
public void visit(){
if(coz==0){
format="type";
}
if(coz==1){
format="VOID";
}
}
}
