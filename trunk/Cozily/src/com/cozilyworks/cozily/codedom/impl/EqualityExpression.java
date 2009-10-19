package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class EqualityExpression extends CodeDocument{
private InstanceOfExpression instanceofexpression;
public void setInstanceOfExpression(InstanceOfExpression t){
this.instanceofexpression=t;
if(single.get("instanceofexpression")==null){single.put("instanceofexpression",instanceofexpression);}
}
private List<EqualOrNotequal> equalornotequals=new ArrayList<EqualOrNotequal>();
public void addEqualOrNotequal(EqualOrNotequal t){
this.equalornotequals.add(t);
if(multi.get("equalornotequal")==null){multi.put("equalornotequal",equalornotequals);}
}
private List<InstanceOfExpression> instanceofexpressions=new ArrayList<InstanceOfExpression>();
public void addInstanceOfExpression(InstanceOfExpression t){
this.instanceofexpressions.add(t);
if(multi.get("instanceofexpression")==null){multi.put("instanceofexpression",instanceofexpressions);}
}
public void visit(){
if(coz==0){
format="instanceOfExpression ( equalOrNotequal instanceOfExpression)*";
}
}
}
