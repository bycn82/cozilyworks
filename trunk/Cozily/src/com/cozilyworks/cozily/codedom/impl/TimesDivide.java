package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class TimesDivide extends CodeDocument{
private String starStr;
public void setSTAR(String t){
this.starStr=t;
if(single.get("star")==null){single.put("star",starStr);}
}
private String slashStr;
public void setSLASH(String t){
this.slashStr=t;
if(single.get("slash")==null){single.put("slash",slashStr);}
}
private String percentStr;
public void setPERCENT(String t){
this.percentStr=t;
if(single.get("percent")==null){single.put("percent",percentStr);}
}
public void visit(){
if(coz==0){
format="STAR";
}
if(coz==1){
format="SLASH";
}
if(coz==2){
format="PERCENT";
}
}
}
