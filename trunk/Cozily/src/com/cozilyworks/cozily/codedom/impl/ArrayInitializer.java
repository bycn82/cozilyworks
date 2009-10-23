package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ArrayInitializer extends CodeDocument{
private ArrayInitializerList arrayinitializerlist;
public void setArrayInitializerList(ArrayInitializerList t){
this.arrayinitializerlist=t;
}
private String commaStr;
public void setCOMMA(String t){
this.commaStr=t;
}
public void visit(){
if(coz==0){
//"'{' arrayInitializerList? COMMA? '}'";
}
}
}
