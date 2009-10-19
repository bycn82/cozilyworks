package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ConditionalOrExpression extends CodeDocument{
private ConditionalAndExpression conditionalandexpression;
public void setConditionalAndExpression(ConditionalAndExpression t){
this.conditionalandexpression=t;
if(single.get("conditionalandexpression")==null){single.put("conditionalandexpression",conditionalandexpression);}
}
private List<ConditionalAndExpression> conditionalandexpressions=new ArrayList<ConditionalAndExpression>();
public void addConditionalAndExpression(ConditionalAndExpression t){
this.conditionalandexpressions.add(t);
if(multi.get("conditionalandexpression")==null){multi.put("conditionalandexpression",conditionalandexpressions);}
}
public void visit(){
if(coz==0){
format="conditionalAndExpression ('||' conditionalAndExpression)*";
}
}
}
