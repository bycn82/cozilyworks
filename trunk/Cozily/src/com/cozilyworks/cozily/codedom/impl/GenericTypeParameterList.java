package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class GenericTypeParameterList extends CodeDocument{
private List<GenericTypeParameter> generictypeparameters=new ArrayList<GenericTypeParameter>();
public void addGenericTypeParameter(GenericTypeParameter t){
this.generictypeparameters.add(t);
}
}
