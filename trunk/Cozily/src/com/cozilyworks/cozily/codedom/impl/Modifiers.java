package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class Modifiers extends CodeDocument{
private List<Modifier> modifiers=new ArrayList<Modifier>();
public void addModifier(Modifier t){
this.modifiers.add(t);
if(multi.get("modifier")==null){multi.put("modifier",modifiers);}
}
public void visit(){
if(coz==0){
format="modifier*";
}
}
}
