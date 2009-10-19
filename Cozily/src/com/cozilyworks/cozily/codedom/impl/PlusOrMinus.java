package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class PlusOrMinus extends CodeDocument{
private String plusStr;
public void setPLUS(String t){
this.plusStr=t;
if(single.get("plus")==null){single.put("plus",plusStr);}
}
private String subStr;
public void setSUB(String t){
this.subStr=t;
if(single.get("sub")==null){single.put("sub",subStr);}
}
public void visit(){
if(coz==0){
format="PLUS";
}
if(coz==1){
format="SUB";
}
}
}
