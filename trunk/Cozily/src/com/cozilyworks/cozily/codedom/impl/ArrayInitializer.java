package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ArrayInitializer extends CodeDocument{
private VariableInitializer variableinitializer;
public void setVariableInitializer(VariableInitializer t){
this.variableinitializer=t;
if(single.get("variableinitializer")==null){single.put("variableinitializer",variableinitializer);}
}
private List<VariableInitializer> variableinitializers=new ArrayList<VariableInitializer>();
public void addVariableInitializer(VariableInitializer t){
this.variableinitializers.add(t);
if(multi.get("variableinitializer")==null){multi.put("variableinitializer",variableinitializers);}
}
private String commaStr;
public void setCOMMA(String t){
this.commaStr=t;
if(single.get("comma")==null){single.put("comma",commaStr);}
}
public void visit(){
if(coz==0){
format="'{' (variableInitializer (',' variableInitializer )* )? (COMMA)? '}'";
}
}
}
