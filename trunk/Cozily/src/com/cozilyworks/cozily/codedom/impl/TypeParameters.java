package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class TypeParameters extends CodeDocument{
private TypeParameter typeparameter;
public void setTypeParameter(TypeParameter t){
this.typeparameter=t;
}
private List<TypeParameter> typeparameters=new ArrayList<TypeParameter>();
public void addTypeParameter(TypeParameter t){
this.typeparameters.add(t);
}
public void visit(){
if(coz==0){
//"'<' typeParameter (',' typeParameter)* '>'";
}
}
}
