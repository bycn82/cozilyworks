package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class TypeArgument extends CodeDocument{
private Type type;
public void setType(Type t){
this.type=t;
if(single.get("type")==null){single.put("type",type);}
}
private ExtendsOrSuper extendsorsuper;
public void setExtendsOrSuper(ExtendsOrSuper t){
this.extendsorsuper=t;
if(single.get("extendsorsuper")==null){single.put("extendsorsuper",extendsorsuper);}
}
public void visit(){
if(coz==0){
format="type";
}
if(coz==1){
format="'?' ( extendsOrSuper type )?";
}
}
}
