package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class DoublePlusMinus extends CodeDocument{
private String plusplusStr;
public void setPLUSPLUS(String t){
this.plusplusStr=t;
}
private String subsubStr;
public void setSUBSUB(String t){
this.subsubStr=t;
}
public void visit(){
if(coz==0){
//"PLUSPLUS";
add(plusplusStr);}
if(coz==1){
//"SUBSUB";
add(subsubStr);}
}
}
