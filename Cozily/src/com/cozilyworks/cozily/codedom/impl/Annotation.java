package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class Annotation extends CodeDocument{
private QualifiedName qualifiedname;
public void setQualifiedName(QualifiedName t){
this.qualifiedname=t;
if(single.get("qualifiedname")==null){single.put("qualifiedname",qualifiedname);}
}
private ElementOfAnno elementofanno;
public void setElementOfAnno(ElementOfAnno t){
this.elementofanno=t;
if(single.get("elementofanno")==null){single.put("elementofanno",elementofanno);}
}
public void visit(){
if(coz==0){
format="'@' qualifiedName (   '(' elementOfAnno?  ')' )?";
}
}
}
