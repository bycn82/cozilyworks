package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ShiftOp extends CodeDocument{
private String ltStr;
public void setLT(String t){
this.ltStr=t;
}
private String gtStr;
public void setGT(String t){
this.gtStr=t;
}
public void visit(){
if(coz==0){
//"LT LT";
}
if(coz==1){
//"GT GT";
}
if(coz==2){
//"GT GT GT";
}
}
}
