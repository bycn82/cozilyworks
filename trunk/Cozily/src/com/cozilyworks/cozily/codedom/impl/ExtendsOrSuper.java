package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ExtendsOrSuper extends CodeDocument{
public void visit(){
if(coz==0){
//"'extends'";
add('extends');}
if(coz==1){
//"'super'";
add('super');}
}
}
