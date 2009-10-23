package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ElementValueArrayInitializer extends CodeDocument{
private ElementValueList elementvaluelist;
public void setElementValueList(ElementValueList t){
this.elementvaluelist=t;
}
private String commaStr;
public void setCOMMA(String t){
this.commaStr=t;
}
public void visit(){
if(coz==0){
//"'{' elementValueList? COMMA? '}'";
}
}
}
