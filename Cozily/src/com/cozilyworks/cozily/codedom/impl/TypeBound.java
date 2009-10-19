package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class TypeBound extends CodeDocument{
private Type type;
public void setType(Type t){
this.type=t;
if(single.get("type")==null){single.put("type",type);}
}
private List<Type> types=new ArrayList<Type>();
public void addType(Type t){
this.types.add(t);
if(multi.get("type")==null){multi.put("type",types);}
}
public void visit(){
if(coz==0){
format="type ('&' type)*";
}
}
}
