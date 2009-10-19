package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class AssignmentOperator extends CodeDocument{
private String eqStr;
public void setEQ(String t){
this.eqStr=t;
if(single.get("eq")==null){single.put("eq",eqStr);}
}
private String pluseqStr;
public void setPLUSEQ(String t){
this.pluseqStr=t;
if(single.get("pluseq")==null){single.put("pluseq",pluseqStr);}
}
private String subeqStr;
public void setSUBEQ(String t){
this.subeqStr=t;
if(single.get("subeq")==null){single.put("subeq",subeqStr);}
}
private String stareqStr;
public void setSTAREQ(String t){
this.stareqStr=t;
if(single.get("stareq")==null){single.put("stareq",stareqStr);}
}
private String slasheqStr;
public void setSLASHEQ(String t){
this.slasheqStr=t;
if(single.get("slasheq")==null){single.put("slasheq",slasheqStr);}
}
private String ampeqStr;
public void setAMPEQ(String t){
this.ampeqStr=t;
if(single.get("ampeq")==null){single.put("ampeq",ampeqStr);}
}
private String bareqStr;
public void setBAREQ(String t){
this.bareqStr=t;
if(single.get("bareq")==null){single.put("bareq",bareqStr);}
}
private String careteqStr;
public void setCARETEQ(String t){
this.careteqStr=t;
if(single.get("careteq")==null){single.put("careteq",careteqStr);}
}
private String percenteqStr;
public void setPERCENTEQ(String t){
this.percenteqStr=t;
if(single.get("percenteq")==null){single.put("percenteq",percenteqStr);}
}
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
format="EQ";
}
if(coz==1){
format="PLUSEQ";
}
if(coz==2){
format="SUBEQ";
}
if(coz==3){
format="STAREQ";
}
if(coz==4){
format="SLASHEQ";
}
if(coz==5){
format="AMPEQ";
}
if(coz==6){
format="BAREQ";
}
if(coz==7){
format="CARETEQ";
}
if(coz==8){
format="PERCENTEQ";
}
if(coz==9){
format="LT LT EQ";
}
if(coz==10){
format="GT GT GT EQ";
}
if(coz==11){
format="GT GT EQ";
}
}
}
