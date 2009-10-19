package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class VariableModifier extends CodeDocument{
private Annotation annotation;
public void setAnnotation(Annotation t){
this.annotation=t;
if(single.get("annotation")==null){single.put("annotation",annotation);}
}
private String finalStr;
public void setFINAL(String t){
this.finalStr=t;
if(single.get("final")==null){single.put("final",finalStr);}
}
public void visit(){
if(coz==0){
format="annotation";
}
if(coz==1){
format="FINAL";
}
}
}
