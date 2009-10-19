package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ElementValuePair extends CodeDocument{
private String identifierStr;
public void setIDENTIFIER(String t){
this.identifierStr=t;
if(single.get("identifier")==null){single.put("identifier",identifierStr);}
}
private ElementValue elementvalue;
public void setElementValue(ElementValue t){
this.elementvalue=t;
if(single.get("elementvalue")==null){single.put("elementvalue",elementvalue);}
}
public void visit(){
if(coz==0){
format="IDENTIFIER '=' elementValue";
}
}
}
