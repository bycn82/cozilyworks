package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class EqualOrNotequal extends CodeDocument{
private String eqeqStr;
public void setEQEQ(String t){
this.eqeqStr=t;
if(single.get("eqeq")==null){single.put("eqeq",eqeqStr);}
}
private String bangeqStr;
public void setBANGEQ(String t){
this.bangeqStr=t;
if(single.get("bangeq")==null){single.put("bangeq",bangeqStr);}
}
public void visit(){
if(coz==0){
format="EQEQ";
}
if(coz==1){
format="BANGEQ";
}
}
}
