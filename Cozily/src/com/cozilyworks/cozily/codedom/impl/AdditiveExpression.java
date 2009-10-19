package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class AdditiveExpression extends CodeDocument{
private MultiplicativeExpression multiplicativeexpression;
public void setMultiplicativeExpression(MultiplicativeExpression t){
this.multiplicativeexpression=t;
if(single.get("multiplicativeexpression")==null){single.put("multiplicativeexpression",multiplicativeexpression);}
}
private List<PlusOrMinus> plusorminuss=new ArrayList<PlusOrMinus>();
public void addPlusOrMinus(PlusOrMinus t){
this.plusorminuss.add(t);
if(multi.get("plusorminus")==null){multi.put("plusorminus",plusorminuss);}
}
private List<MultiplicativeExpression> multiplicativeexpressions=new ArrayList<MultiplicativeExpression>();
public void addMultiplicativeExpression(MultiplicativeExpression t){
this.multiplicativeexpressions.add(t);
if(multi.get("multiplicativeexpression")==null){multi.put("multiplicativeexpression",multiplicativeexpressions);}
}
public void visit(){
if(coz==0){
format="multiplicativeExpression ( plusOrMinus multiplicativeExpression)*";
}
}
}
