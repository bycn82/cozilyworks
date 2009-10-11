package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class VariableDeclarator extends CodeDocument{
private VariableDeclaratorId variabledeclaratorid1;
public void setVariableDeclaratorId(VariableDeclaratorId t){
this.variabledeclaratorid1=t;
}
private VariableInitializer variableinitializer2;
public void setVariableInitializer(VariableInitializer t){
this.variableinitializer2=t;
}
}
