package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class Trystatement extends CodeDocument{
private Block block;
public void setBlock(Block t){
this.block=t;
}
private Catches catches;
public void setCatches(Catches t){
this.catches=t;
}
public void visit(){
if(coz==0){
//"'try' block catches 'finally' block";
}
if(coz==1){
//"'try' block catches";
}
if(coz==2){
//"'try' block 'finally' block";
}
}
}
