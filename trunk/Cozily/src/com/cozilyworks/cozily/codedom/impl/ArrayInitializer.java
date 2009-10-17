package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ArrayInitializer extends CodeDocument{
private VariableInitializer variableinitializer;
public void setVariableInitializer(VariableInitializer t){
this.variableinitializer=t;
}
private String commaStr;
public void setCOMMA(String t){
this.commaStr=t;
}
}
