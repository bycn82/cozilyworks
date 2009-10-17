package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ElementValuePair extends CodeDocument{
private String identifierStr;
public void setIDENTIFIER(String t){
this.identifierStr=t;
}
private ElementValue elementvalue;
public void setElementValue(ElementValue t){
this.elementvalue=t;
}
}
