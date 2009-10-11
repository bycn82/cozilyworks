package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class LocalModifierList extends CodeDocument{
private List<LocalModifier> localmodifiers=new ArrayList<LocalModifier>();
public void addLocalModifier(LocalModifier t){
this.localmodifiers.add(t);
}
}
