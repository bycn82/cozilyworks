package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class InstanceOfExpression extends CodeDocument{
private RelationalExpression relationalexpression;
public void setRelationalExpression(RelationalExpression t){
this.relationalexpression=t;
if(single.get("relationalexpression")==null){single.put("relationalexpression",relationalexpression);}
}
private Type type;
public void setType(Type t){
this.type=t;
if(single.get("type")==null){single.put("type",type);}
}
public void visit(){
if(coz==0){
format="relationalExpression ('instanceof' type )?";
}
}
}
