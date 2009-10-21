package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class PrimitiveType extends CodeDocument{
private String booleanStr;
public void setBOOLEAN(String t){
this.booleanStr=t;
}
private String charStr;
public void setCHAR(String t){
this.charStr=t;
}
private String byteStr;
public void setBYTE(String t){
this.byteStr=t;
}
private String shortStr;
public void setSHORT(String t){
this.shortStr=t;
}
private String intStr;
public void setINT(String t){
this.intStr=t;
}
private String longStr;
public void setLONG(String t){
this.longStr=t;
}
private String floatStr;
public void setFLOAT(String t){
this.floatStr=t;
}
private String doubleStr;
public void setDOUBLE(String t){
this.doubleStr=t;
}
public void visit(){
if(coz==0){
//"BOOLEAN";
add(booleanStr);}
if(coz==1){
//"CHAR";
add(charStr);}
if(coz==2){
//"BYTE";
add(byteStr);}
if(coz==3){
//"SHORT";
add(shortStr);}
if(coz==4){
//"INT";
add(intStr);}
if(coz==5){
//"LONG";
add(longStr);}
if(coz==6){
//"FLOAT";
add(floatStr);}
if(coz==7){
//"DOUBLE";
add(doubleStr);}
}
}
