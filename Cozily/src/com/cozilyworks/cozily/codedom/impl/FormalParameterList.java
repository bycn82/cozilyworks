package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class FormalParameterList extends CodeDocument{
private List<FormalParameterStandardDecl> formalparameterstandarddecls=new ArrayList<FormalParameterStandardDecl>();
public void addFormalParameterStandardDecl(FormalParameterStandardDecl t){
this.formalparameterstandarddecls.add(t);
}
private FormalParameterVarargDecl formalparametervarargdecl2;
public void setFormalParameterVarargDecl(FormalParameterVarargDecl t){
this.formalparametervarargdecl2=t;
}
}
