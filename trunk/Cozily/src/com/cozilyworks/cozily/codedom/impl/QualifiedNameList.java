package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class QualifiedNameList extends CodeDocument{
private List<QualifiedName> qualifiednames=new ArrayList<QualifiedName>();
public void addQualifiedName(QualifiedName t){
this.qualifiednames.add(t);
if(multi.get("qualifiedname")==null){multi.put("qualifiedname",qualifiednames);}
}
public void visit(){
if(coz==0){
format="(',' qualifiedName)*";
}
}
}
