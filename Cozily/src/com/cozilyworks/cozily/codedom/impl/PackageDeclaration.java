package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class PackageDeclaration extends CodeDocument{
private QualifiedName qualifiedname;
public void setQualifiedName(QualifiedName t){
this.qualifiedname=t;
if(single.get("qualifiedname")==null){single.put("qualifiedname",qualifiedname);}
}
public void visit(){
if(coz==0){
format="'package' qualifiedName ';'";
}
}
}
