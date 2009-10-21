package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class BlockOrComma extends CodeDocument{
private Block block;
public void setBlock(Block t){
this.block=t;
}
private String semiStr;
public void setSEMI(String t){
this.semiStr=t;
}
public void visit(){
if(coz==0){
//"block";
}
if(coz==1){
//"SEMI";
}
}
}
