package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class Trystatement extends CodeDocument{
private Block block;
public void setBlock(Block t){
this.block=t;
if(single.get("block")==null){single.put("block",block);}
}
private Catches catches;
public void setCatches(Catches t){
this.catches=t;
if(single.get("catches")==null){single.put("catches",catches);}
}
public void visit(){
if(coz==0){
format="'try' block   catches 'finally' block";
}
if(coz==1){
format="'try' block  catches";
}
if(coz==2){
format="'try' block  'finally' block";
}
}
}
