package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ClassCreatorRest extends CodeDocument{
private Arguments arguments;
public void setArguments(Arguments t){
this.arguments=t;
}
private ClassBody classbody;
public void setClassBody(ClassBody t){
this.classbody=t;
}
public void visit(){
if(coz==0){
//"arguments classBody?";
}
}
}
