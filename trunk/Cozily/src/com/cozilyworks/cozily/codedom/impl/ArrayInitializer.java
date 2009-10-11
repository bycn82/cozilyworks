package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ArrayInitializer extends CodeDocument{
private List<VariableInitializer> variableinitializers=new ArrayList<VariableInitializer>();
public void addVariableInitializer(VariableInitializer t){
this.variableinitializers.add(t);
}
}
