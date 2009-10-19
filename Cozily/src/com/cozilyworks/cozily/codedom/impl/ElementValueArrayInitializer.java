package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ElementValueArrayInitializer extends CodeDocument{
private ElementValue elementvalue;
public void setElementValue(ElementValue t){
this.elementvalue=t;
if(single.get("elementvalue")==null){single.put("elementvalue",elementvalue);}
}
private List<ElementValue> elementvalues=new ArrayList<ElementValue>();
public void addElementValue(ElementValue t){
this.elementvalues.add(t);
if(multi.get("elementvalue")==null){multi.put("elementvalue",elementvalues);}
}
private String commaStr;
public void setCOMMA(String t){
this.commaStr=t;
if(single.get("comma")==null){single.put("comma",commaStr);}
}
public void visit(){
if(coz==0){
format="'{'(elementValue  (',' elementValue)*  )? COMMA? '}'";
}
}
}
