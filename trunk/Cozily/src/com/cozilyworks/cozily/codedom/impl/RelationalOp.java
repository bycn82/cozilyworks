package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class RelationalOp extends CodeDocument{
public void visit(){
if(coz==0){
//"'<' '='";
}
if(coz==1){
//"'>' '='";
}
if(coz==2){
//"'<'";
add('<');}
if(coz==3){
//"'>'";
add('>');}
}
}
