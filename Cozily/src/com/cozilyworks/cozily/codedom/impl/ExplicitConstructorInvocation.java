package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ExplicitConstructorInvocation extends CodeDocument{
private NonWildcardTypeArguments nonwildcardtypearguments;
public void setNonWildcardTypeArguments(NonWildcardTypeArguments t){
this.nonwildcardtypearguments=t;
}
private ThisOrSuper thisorsuper;
public void setThisOrSuper(ThisOrSuper t){
this.thisorsuper=t;
}
private Arguments arguments;
public void setArguments(Arguments t){
this.arguments=t;
}
private Primary primary;
public void setPrimary(Primary t){
this.primary=t;
}
public void visit(){
if(coz==0){
//"nonWildcardTypeArguments? thisOrSuper arguments ';'";
}
if(coz==1){
//"primary '.' nonWildcardTypeArguments? 'super' arguments ';'";
}
}
}
