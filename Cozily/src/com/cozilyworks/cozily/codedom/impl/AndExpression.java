package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class AndExpression extends CodeDocument{
private EqualityExpression equalityexpression;
public void setEqualityExpression(EqualityExpression t){
this.equalityexpression=t;
if(single.get("equalityexpression")==null){single.put("equalityexpression",equalityexpression);}
}
private List<EqualityExpression> equalityexpressions=new ArrayList<EqualityExpression>();
public void addEqualityExpression(EqualityExpression t){
this.equalityexpressions.add(t);
if(multi.get("equalityexpression")==null){multi.put("equalityexpression",equalityexpressions);}
}
public void visit(){
if(coz==0){
format="equalityExpression ('&' equalityExpression)*";
}
}
}
