package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class CatchClause extends CodeDocument{
private FormalParameter formalparameter;
public void setFormalParameter(FormalParameter t){
this.formalparameter=t;
if(single.get("formalparameter")==null){single.put("formalparameter",formalparameter);}
}
private Block block;
public void setBlock(Block t){
this.block=t;
if(single.get("block")==null){single.put("block",block);}
}
public void visit(){
if(coz==0){
format="'catch' '(' formalParameter ')' block";
}
}
}
