package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class TimesDivide extends CodeDocument{
private String starStr;
public void setSTAR(String t){
this.starStr=t;
}
private String slashStr;
public void setSLASH(String t){
this.slashStr=t;
}
private String percentStr;
public void setPERCENT(String t){
this.percentStr=t;
}
public void visit(){
if(coz==0){
//"STAR";
add(starStr);}
if(coz==1){
//"SLASH";
add(slashStr);}
if(coz==2){
//"PERCENT";
add(percentStr);}
}
}
