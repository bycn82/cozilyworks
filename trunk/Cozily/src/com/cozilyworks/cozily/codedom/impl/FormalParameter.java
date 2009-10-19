package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class FormalParameter extends CodeDocument{
private VariableModifiers variablemodifiers;
public void setVariableModifiers(VariableModifiers t){
this.variablemodifiers=t;
if(single.get("variablemodifiers")==null){single.put("variablemodifiers",variablemodifiers);}
}
private Type type;
public void setType(Type t){
this.type=t;
if(single.get("type")==null){single.put("type",type);}
}
private String identifierStr;
public void setIDENTIFIER(String t){
this.identifierStr=t;
if(single.get("identifier")==null){single.put("identifier",identifierStr);}
}
private List<String> bracketss=new ArrayList<String>();
public void addBRACKETS(String t){
this.bracketss.add(t);
if(multi.get("brackets")==null){multi.put("brackets",bracketss);}
}
public void visit(){
if(coz==0){
format="variableModifiers type IDENTIFIER BRACKETS*";
}
}
}
