package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class InclusiveOrExpression extends CodeDocument{
private ExclusiveOrExpression exclusiveorexpression;
public void setExclusiveOrExpression(ExclusiveOrExpression t){
this.exclusiveorexpression=t;
if(single.get("exclusiveorexpression")==null){single.put("exclusiveorexpression",exclusiveorexpression);}
}
private List<ExclusiveOrExpression> exclusiveorexpressions=new ArrayList<ExclusiveOrExpression>();
public void addExclusiveOrExpression(ExclusiveOrExpression t){
this.exclusiveorexpressions.add(t);
if(multi.get("exclusiveorexpression")==null){multi.put("exclusiveorexpression",exclusiveorexpressions);}
}
public void visit(){
if(coz==0){
format="exclusiveOrExpression ('|' exclusiveOrExpression)*";
}
}
}
