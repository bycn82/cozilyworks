package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class UnaryExpressionNotPlusMinus extends CodeDocument{
private UnaryExpression unaryexpression;
public void setUnaryExpression(UnaryExpression t){
this.unaryexpression=t;
if(single.get("unaryexpression")==null){single.put("unaryexpression",unaryexpression);}
}
private CastExpression castexpression;
public void setCastExpression(CastExpression t){
this.castexpression=t;
if(single.get("castexpression")==null){single.put("castexpression",castexpression);}
}
private Primary primary;
public void setPrimary(Primary t){
this.primary=t;
if(single.get("primary")==null){single.put("primary",primary);}
}
private List<Selector> selectors=new ArrayList<Selector>();
public void addSelector(Selector t){
this.selectors.add(t);
if(multi.get("selector")==null){multi.put("selector",selectors);}
}
private DoublePlusMinus doubleplusminus;
public void setDoublePlusMinus(DoublePlusMinus t){
this.doubleplusminus=t;
if(single.get("doubleplusminus")==null){single.put("doubleplusminus",doubleplusminus);}
}
public void visit(){
if(coz==0){
format="'~' unaryExpression";
}
if(coz==1){
format="'!' unaryExpression";
}
if(coz==2){
format="castExpression";
}
if(coz==3){
format="primary selector* doublePlusMinus?";
}
}
}
