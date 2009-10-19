package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ImportDeclaration extends CodeDocument{
private String staticStr;
public void setSTATIC(String t){
this.staticStr=t;
if(single.get("static")==null){single.put("static",staticStr);}
}
private QualifiedName qualifiedname;
public void setQualifiedName(QualifiedName t){
this.qualifiedname=t;
if(single.get("qualifiedname")==null){single.put("qualifiedname",qualifiedname);}
}
private String dotstarStr;
public void setDOTSTAR(String t){
this.dotstarStr=t;
if(single.get("dotstar")==null){single.put("dotstar",dotstarStr);}
}
public void visit(){
if(coz==0){
format="'import' STATIC? qualifiedName DOTSTAR? ';'";
}
}
}
