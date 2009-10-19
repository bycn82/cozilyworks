package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ShiftExpression extends CodeDocument{
private AdditiveExpression additiveexpression;
public void setAdditiveExpression(AdditiveExpression t){
this.additiveexpression=t;
if(single.get("additiveexpression")==null){single.put("additiveexpression",additiveexpression);}
}
private List<ShiftOp> shiftops=new ArrayList<ShiftOp>();
public void addShiftOp(ShiftOp t){
this.shiftops.add(t);
if(multi.get("shiftop")==null){multi.put("shiftop",shiftops);}
}
private List<AdditiveExpression> additiveexpressions=new ArrayList<AdditiveExpression>();
public void addAdditiveExpression(AdditiveExpression t){
this.additiveexpressions.add(t);
if(multi.get("additiveexpression")==null){multi.put("additiveexpression",additiveexpressions);}
}
public void visit(){
if(coz==0){
format="additiveExpression (shiftOp additiveExpression)*";
}
}
}
