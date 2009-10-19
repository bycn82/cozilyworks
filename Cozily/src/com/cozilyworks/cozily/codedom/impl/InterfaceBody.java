package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class InterfaceBody extends CodeDocument{
private List<InterfaceBodyDeclaration> interfacebodydeclarations=new ArrayList<InterfaceBodyDeclaration>();
public void addInterfaceBodyDeclaration(InterfaceBodyDeclaration t){
this.interfacebodydeclarations.add(t);
if(multi.get("interfacebodydeclaration")==null){multi.put("interfacebodydeclaration",interfacebodydeclarations);}
}
public void visit(){
if(coz==0){
format="'{' interfaceBodyDeclaration* '}'";
}
}
}
