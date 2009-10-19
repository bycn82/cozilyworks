package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class EnumConstants extends CodeDocument{
private EnumConstant enumconstant;
public void setEnumConstant(EnumConstant t){
this.enumconstant=t;
if(single.get("enumconstant")==null){single.put("enumconstant",enumconstant);}
}
private List<EnumConstant> enumconstants=new ArrayList<EnumConstant>();
public void addEnumConstant(EnumConstant t){
this.enumconstants.add(t);
if(multi.get("enumconstant")==null){multi.put("enumconstant",enumconstants);}
}
public void visit(){
if(coz==0){
format="enumConstant (',' enumConstant)*";
}
}
}
