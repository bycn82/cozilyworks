package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class MultiplicativeExpression extends CodeDocument{
private UnaryExpression unaryexpression;
public void setUnaryExpression(UnaryExpression t){
this.unaryexpression=t;
}
private List<StarSlashPercent> starslashpercents=new ArrayList<StarSlashPercent>();
public void addStarSlashPercent(StarSlashPercent t){
this.starslashpercents.add(t);
}
private List<UnaryExpression> unaryexpressions=new ArrayList<UnaryExpression>();
public void addUnaryExpression(UnaryExpression t){
this.unaryexpressions.add(t);
}
public void visit(){
if(coz==0){
//"unaryExpression (starSlashPercent unaryExpression )*";
}
}
}
