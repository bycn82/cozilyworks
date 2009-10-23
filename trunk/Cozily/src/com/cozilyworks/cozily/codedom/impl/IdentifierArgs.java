package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class IdentifierArgs extends CodeDocument{
private String identifierStr;
public void setIDENTIFIER(String t){
this.identifierStr=t;
}
private TypeArguments typearguments;
public void setTypeArguments(TypeArguments t){
this.typearguments=t;
}
public void visit(){
if(coz==0){
//"IDENTIFIER typeArguments?";
}
}
}
