package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ThisOrSuper extends CodeDocument{
private String thisStr;
public void setTHIS(String t){
this.thisStr=t;
if(single.get("this")==null){single.put("this",thisStr);}
}
private String superStr;
public void setSUPER(String t){
this.superStr=t;
if(single.get("super")==null){single.put("super",superStr);}
}
public void visit(){
if(coz==0){
format="THIS";
}
if(coz==1){
format="SUPER";
}
}
}
