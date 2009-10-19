package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class QualifiedName extends CodeDocument{
private String identifierStr;
public void setIDENTIFIER(String t){
this.identifierStr=t;
if(single.get("identifier")==null){single.put("identifier",identifierStr);}
}
private List<String> identifiers=new ArrayList<String>();
public void addIDENTIFIER(String t){
this.identifiers.add(t);
if(multi.get("identifier")==null){multi.put("identifier",identifiers);}
}
public void visit(){
if(coz==0){
format="IDENTIFIER ('.' IDENTIFIER)*";
}
}
}
