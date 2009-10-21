package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ExtendsOrSuper extends CodeDocument{
private String extendsStr;
public void setEXTENDS(String t){
this.extendsStr=t;
}
private String superStr;
public void setSUPER(String t){
this.superStr=t;
}
public void visit(){
if(coz==0){
//"EXTENDS";
}
if(coz==1){
//"SUPER";
}
}
}
