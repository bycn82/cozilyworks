package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class RelationalExpression extends CodeDocument{
private ShiftExpression shiftexpression;
public void setShiftExpression(ShiftExpression t){
this.shiftexpression=t;
if(single.get("shiftexpression")==null){single.put("shiftexpression",shiftexpression);}
}
private List<RelationalOp> relationalops=new ArrayList<RelationalOp>();
public void addRelationalOp(RelationalOp t){
this.relationalops.add(t);
if(multi.get("relationalop")==null){multi.put("relationalop",relationalops);}
}
private List<ShiftExpression> shiftexpressions=new ArrayList<ShiftExpression>();
public void addShiftExpression(ShiftExpression t){
this.shiftexpressions.add(t);
if(multi.get("shiftexpression")==null){multi.put("shiftexpression",shiftexpressions);}
}
public void visit(){
if(coz==0){
format="shiftExpression (relationalOp shiftExpression)*";
}
}
}
