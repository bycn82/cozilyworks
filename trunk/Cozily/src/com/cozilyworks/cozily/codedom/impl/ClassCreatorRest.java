package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ClassCreatorRest extends CodeDocument{
private Arguments arguments;
public void setArguments(Arguments t){
this.arguments=t;
if(single.get("arguments")==null){single.put("arguments",arguments);}
}
private ClassBody classbody;
public void setClassBody(ClassBody t){
this.classbody=t;
if(single.get("classbody")==null){single.put("classbody",classbody);}
}
public void visit(){
if(coz==0){
format="arguments classBody?";
}
}
}
