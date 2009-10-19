package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class DoublePlusMinus extends CodeDocument{
private String plusplusStr;
public void setPLUSPLUS(String t){
this.plusplusStr=t;
if(single.get("plusplus")==null){single.put("plusplus",plusplusStr);}
}
private String subsubStr;
public void setSUBSUB(String t){
this.subsubStr=t;
if(single.get("subsub")==null){single.put("subsub",subsubStr);}
}
public void visit(){
if(coz==0){
format="PLUSPLUS";
}
if(coz==1){
format="SUBSUB";
}
}
}
