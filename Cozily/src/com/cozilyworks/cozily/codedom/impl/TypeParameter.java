package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class TypeParameter extends CodeDocument{
private String identifierStr;
public void setIDENTIFIER(String t){
this.identifierStr=t;
if(single.get("identifier")==null){single.put("identifier",identifierStr);}
}
private TypeBound typebound;
public void setTypeBound(TypeBound t){
this.typebound=t;
if(single.get("typebound")==null){single.put("typebound",typebound);}
}
public void visit(){
if(coz==0){
format="IDENTIFIER ('extends' typeBound)?";
}
}
}
