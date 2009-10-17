package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class EnumDeclaration extends CodeDocument{
private Modifiers modifiers;
public void setModifiers(Modifiers t){
this.modifiers=t;
}
private String identifierStr;
public void setIDENTIFIER(String t){
this.identifierStr=t;
}
private TypeList typelist;
public void setTypeList(TypeList t){
this.typelist=t;
}
private EnumBody enumbody;
public void setEnumBody(EnumBody t){
this.enumbody=t;
}
}
