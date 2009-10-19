package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class EnumConstant extends CodeDocument{
private Annotations annotations;
public void setAnnotations(Annotations t){
this.annotations=t;
if(single.get("annotations")==null){single.put("annotations",annotations);}
}
private String identifierStr;
public void setIDENTIFIER(String t){
this.identifierStr=t;
if(single.get("identifier")==null){single.put("identifier",identifierStr);}
}
private Arguments arguments;
public void setArguments(Arguments t){
this.arguments=t;
if(single.get("arguments")==null){single.put("arguments",arguments);}
}
private ClassBody classbody;
public void setClassBody(ClassBody t){
this.classbody=t;
if(single.get("classbody")==null){single.put("classbody",classbody);}
}
public void visit(){
if(coz==0){
format="annotations? IDENTIFIER arguments? classBody?";
}
}
}
