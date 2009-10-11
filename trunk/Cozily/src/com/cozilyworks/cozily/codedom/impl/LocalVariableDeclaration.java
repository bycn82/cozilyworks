package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class LocalVariableDeclaration extends CodeDocument{
private LocalModifierList localmodifierlist1;
public void setLocalModifierList(LocalModifierList t){
this.localmodifierlist1=t;
}
private Type type2;
public void setType(Type t){
this.type2=t;
}
private VariableDeclaratorList variabledeclaratorlist3;
public void setVariableDeclaratorList(VariableDeclaratorList t){
this.variabledeclaratorlist3=t;
}
}
