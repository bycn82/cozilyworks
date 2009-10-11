package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class InterfaceTopLevelScope extends CodeDocument{
private List<InterfaceScopeDeclarations> interfacescopedeclarationss=new ArrayList<InterfaceScopeDeclarations>();
public void addInterfaceScopeDeclarations(InterfaceScopeDeclarations t){
this.interfacescopedeclarationss.add(t);
}
}
