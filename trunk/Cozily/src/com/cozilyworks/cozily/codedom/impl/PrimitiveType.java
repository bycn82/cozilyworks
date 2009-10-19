package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class PrimitiveType extends CodeDocument{
private String booleanStr;
public void setBOOLEAN(String t){
this.booleanStr=t;
if(single.get("boolean")==null){single.put("boolean",booleanStr);}
}
private String charStr;
public void setCHAR(String t){
this.charStr=t;
if(single.get("char")==null){single.put("char",charStr);}
}
private String byteStr;
public void setBYTE(String t){
this.byteStr=t;
if(single.get("byte")==null){single.put("byte",byteStr);}
}
private String shortStr;
public void setSHORT(String t){
this.shortStr=t;
if(single.get("short")==null){single.put("short",shortStr);}
}
private String intStr;
public void setINT(String t){
this.intStr=t;
if(single.get("int")==null){single.put("int",intStr);}
}
private String longStr;
public void setLONG(String t){
this.longStr=t;
if(single.get("long")==null){single.put("long",longStr);}
}
private String floatStr;
public void setFLOAT(String t){
this.floatStr=t;
if(single.get("float")==null){single.put("float",floatStr);}
}
private String doubleStr;
public void setDOUBLE(String t){
this.doubleStr=t;
if(single.get("double")==null){single.put("double",doubleStr);}
}
public void visit(){
if(coz==0){
format="BOOLEAN";
}
if(coz==1){
format="CHAR";
}
if(coz==2){
format="BYTE";
}
if(coz==3){
format="SHORT";
}
if(coz==4){
format="INT";
}
if(coz==5){
format="LONG";
}
if(coz==6){
format="FLOAT";
}
if(coz==7){
format="DOUBLE";
}
}
}
