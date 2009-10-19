package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class BlockOrComma extends CodeDocument{
private Block block;
public void setBlock(Block t){
this.block=t;
if(single.get("block")==null){single.put("block",block);}
}
private String semiStr;
public void setSEMI(String t){
this.semiStr=t;
if(single.get("semi")==null){single.put("semi",semiStr);}
}
public void visit(){
if(coz==0){
format="block";
}
if(coz==1){
format="SEMI";
}
}
}
