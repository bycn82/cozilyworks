package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ExclusiveOrExpression extends CodeDocument{
private AndExpression andexpression;
public void setAndExpression(AndExpression t){
this.andexpression=t;
if(single.get("andexpression")==null){single.put("andexpression",andexpression);}
}
private List<AndExpression> andexpressions=new ArrayList<AndExpression>();
public void addAndExpression(AndExpression t){
this.andexpressions.add(t);
if(multi.get("andexpression")==null){multi.put("andexpression",andexpressions);}
}
public void visit(){
if(coz==0){
format="andExpression ('^' andExpression)*";
}
}
}
