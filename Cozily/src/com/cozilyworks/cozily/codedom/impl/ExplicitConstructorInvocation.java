package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ExplicitConstructorInvocation extends CodeDocument{
private NonWildcardTypeArguments nonwildcardtypearguments;
public void setNonWildcardTypeArguments(NonWildcardTypeArguments t){
this.nonwildcardtypearguments=t;
if(single.get("nonwildcardtypearguments")==null){single.put("nonwildcardtypearguments",nonwildcardtypearguments);}
}
private ThisOrSuper thisorsuper;
public void setThisOrSuper(ThisOrSuper t){
this.thisorsuper=t;
if(single.get("thisorsuper")==null){single.put("thisorsuper",thisorsuper);}
}
private Arguments arguments;
public void setArguments(Arguments t){
this.arguments=t;
if(single.get("arguments")==null){single.put("arguments",arguments);}
}
private Primary primary;
public void setPrimary(Primary t){
this.primary=t;
if(single.get("primary")==null){single.put("primary",primary);}
}
public void visit(){
if(coz==0){
format="nonWildcardTypeArguments? thisOrSuper arguments ';'";
}
if(coz==1){
format="primary '.' nonWildcardTypeArguments? 'super' arguments ';'";
}
}
}
