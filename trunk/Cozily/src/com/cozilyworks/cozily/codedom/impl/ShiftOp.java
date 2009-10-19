package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ShiftOp extends CodeDocument{
private String ltStr;
public void setLT(String t){
this.ltStr=t;
if(single.get("lt")==null){single.put("lt",ltStr);}
}
private String gtStr;
public void setGT(String t){
this.gtStr=t;
if(single.get("gt")==null){single.put("gt",gtStr);}
}
public void visit(){
if(coz==0){
format="LT LT";
}
if(coz==1){
format="GT GT";
}
if(coz==2){
format="GT GT GT";
}
}
}
