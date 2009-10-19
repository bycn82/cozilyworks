package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class MultiplicativeExpression extends CodeDocument{
private UnaryExpression unaryexpression;
public void setUnaryExpression(UnaryExpression t){
this.unaryexpression=t;
if(single.get("unaryexpression")==null){single.put("unaryexpression",unaryexpression);}
}
private List<TimesDivide> timesdivides=new ArrayList<TimesDivide>();
public void addTimesDivide(TimesDivide t){
this.timesdivides.add(t);
if(multi.get("timesdivide")==null){multi.put("timesdivide",timesdivides);}
}
private List<UnaryExpression> unaryexpressions=new ArrayList<UnaryExpression>();
public void addUnaryExpression(UnaryExpression t){
this.unaryexpressions.add(t);
if(multi.get("unaryexpression")==null){multi.put("unaryexpression",unaryexpressions);}
}
public void visit(){
if(coz==0){
format="unaryExpression ( timesDivide unaryExpression)*";
}
}
}
