package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class EnumBody extends CodeDocument{
private EnumConstants enumconstants;
public void setEnumConstants(EnumConstants t){
this.enumconstants=t;
if(single.get("enumconstants")==null){single.put("enumconstants",enumconstants);}
}
private String commaStr;
public void setCOMMA(String t){
this.commaStr=t;
if(single.get("comma")==null){single.put("comma",commaStr);}
}
private EnumBodyDeclarations enumbodydeclarations;
public void setEnumBodyDeclarations(EnumBodyDeclarations t){
this.enumbodydeclarations=t;
if(single.get("enumbodydeclarations")==null){single.put("enumbodydeclarations",enumbodydeclarations);}
}
public void visit(){
if(coz==0){
format="'{' enumConstants? COMMA? (enumBodyDeclarations)? '}'";
}
}
}
