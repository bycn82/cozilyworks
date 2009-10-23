package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ShiftExpression extends CodeDocument{
private AdditiveExpression additiveexpression;
public void setAdditiveExpression(AdditiveExpression t){
this.additiveexpression=t;
}
private List<ShiftOp> shiftops=new ArrayList<ShiftOp>();
public void addShiftOp(ShiftOp t){
this.shiftops.add(t);
}
private List<AdditiveExpression> additiveexpressions=new ArrayList<AdditiveExpression>();
public void addAdditiveExpression(AdditiveExpression t){
this.additiveexpressions.add(t);
}
public void visit(){
if(coz==0){
//"additiveExpression (shiftOp additiveExpression)*";
}
}
}
