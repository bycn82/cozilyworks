package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class TypeArguments extends CodeDocument{
private TypeArgument typeargument;
public void setTypeArgument(TypeArgument t){
this.typeargument=t;
if(single.get("typeargument")==null){single.put("typeargument",typeargument);}
}
private List<TypeArgument> typearguments=new ArrayList<TypeArgument>();
public void addTypeArgument(TypeArgument t){
this.typearguments.add(t);
if(multi.get("typeargument")==null){multi.put("typeargument",typearguments);}
}
public void visit(){
if(coz==0){
format="'<' typeArgument (',' typeArgument)* '>'";
}
}
}
