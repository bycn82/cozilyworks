package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class GenericTypeArgumentList extends CodeDocument{
private List<GenericTypeArgument> generictypearguments=new ArrayList<GenericTypeArgument>();
public void addGenericTypeArgument(GenericTypeArgument t){
this.generictypearguments.add(t);
}
}
