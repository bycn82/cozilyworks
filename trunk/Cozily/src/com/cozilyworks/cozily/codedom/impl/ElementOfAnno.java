package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ElementOfAnno extends CodeDocument{
private ElementValuePairs elementvaluepairs;
public void setElementValuePairs(ElementValuePairs t){
this.elementvaluepairs=t;
if(single.get("elementvaluepairs")==null){single.put("elementvaluepairs",elementvaluepairs);}
}
private ElementValue elementvalue;
public void setElementValue(ElementValue t){
this.elementvalue=t;
if(single.get("elementvalue")==null){single.put("elementvalue",elementvalue);}
}
public void visit(){
if(coz==0){
format="elementValuePairs";
}
if(coz==1){
format="elementValue";
}
}
}
