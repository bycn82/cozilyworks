package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class NormalInterfaceDeclaration extends CodeDocument{
private Modifiers modifiers;
public void setModifiers(Modifiers t){
this.modifiers=t;
}
private String identifierStr;
public void setIDENTIFIER(String t){
this.identifierStr=t;
}
private TypeParameters typeparameters;
public void setTypeParameters(TypeParameters t){
this.typeparameters=t;
}
private TypeList typelist;
public void setTypeList(TypeList t){
this.typelist=t;
}
private InterfaceBody interfacebody;
public void setInterfaceBody(InterfaceBody t){
this.interfacebody=t;
}
}
