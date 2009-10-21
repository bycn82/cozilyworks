package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class PlusOrMinus extends CodeDocument{
private String plusStr;
public void setPLUS(String t){
this.plusStr=t;
}
private String subStr;
public void setSUB(String t){
this.subStr=t;
}
public void visit(){
if(coz==0){
//"PLUS";
}
if(coz==1){
//"SUB";
}
}
}
