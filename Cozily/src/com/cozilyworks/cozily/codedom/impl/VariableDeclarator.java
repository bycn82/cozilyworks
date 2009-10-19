package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class VariableDeclarator extends CodeDocument{
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
private VariableInitializer variableinitializer;
public void setVariableInitializer(VariableInitializer t){
this.variableinitializer=t;
if(single.get("variableinitializer")==null){single.put("variableinitializer",variableinitializer);}
}
public void visit(){
if(coz==0){
format="IDENTIFIER BRACKETS* ('=' variableInitializer)?";
}
}
}
