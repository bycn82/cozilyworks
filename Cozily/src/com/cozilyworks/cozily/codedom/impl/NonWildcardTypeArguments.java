package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class NonWildcardTypeArguments extends CodeDocument{
private TypeList typelist;
public void setTypeList(TypeList t){
this.typelist=t;
if(single.get("typelist")==null){single.put("typelist",typelist);}
}
public void visit(){
if(coz==0){
format="'<' typeList '>'";
}
}
}
