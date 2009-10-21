package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class TypeArguments extends CodeDocument{
private TypeArgument typeargument;
public void setTypeArgument(TypeArgument t){
this.typeargument=t;
}
private List<TypeArgument> typearguments=new ArrayList<TypeArgument>();
public void addTypeArgument(TypeArgument t){
this.typearguments.add(t);
}
public void visit(){
if(coz==0){
//"'<' typeArgument (',' typeArgument)* '>'";
}
}
}
