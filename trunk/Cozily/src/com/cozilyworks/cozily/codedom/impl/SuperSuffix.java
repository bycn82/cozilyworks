package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class SuperSuffix extends CodeDocument{
private Arguments arguments;
public void setArguments(Arguments t){
this.arguments=t;
}
private TypeArguments typearguments;
public void setTypeArguments(TypeArguments t){
this.typearguments=t;
}
private String identifierStr;
public void setIDENTIFIER(String t){
this.identifierStr=t;
}
}
