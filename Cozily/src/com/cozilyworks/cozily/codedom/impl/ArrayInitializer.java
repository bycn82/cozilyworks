package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ArrayInitializer extends CodeDocument{
private VariableInitializer variableinitializer;
public void setVariableInitializer(VariableInitializer t){
this.variableinitializer=t;
}
private List<VariableInitializer> variableinitializers=new ArrayList<VariableInitializer>();
public void addVariableInitializer(VariableInitializer t){
this.variableinitializers.add(t);
}
private String commaStr;
public void setCOMMA(String t){
this.commaStr=t;
}
public void visit(){
if(coz==0){
//"'{' (variableInitializer (',' variableInitializer )* )? (COMMA)? '}'";
}
}
}
