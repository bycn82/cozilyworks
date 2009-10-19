package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ExtendsOrSuper extends CodeDocument{
private String extendsStr;
public void setEXTENDS(String t){
this.extendsStr=t;
if(single.get("extends")==null){single.put("extends",extendsStr);}
}
private String superStr;
public void setSUPER(String t){
this.superStr=t;
if(single.get("super")==null){single.put("super",superStr);}
}
public void visit(){
if(coz==0){
format="EXTENDS";
}
if(coz==1){
format="SUPER";
}
}
}
