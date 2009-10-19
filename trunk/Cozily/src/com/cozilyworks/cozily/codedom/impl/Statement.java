package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class Statement extends CodeDocument{
private Block block;
public void setBlock(Block t){
this.block=t;
if(single.get("block")==null){single.put("block",block);}
}
private Expression expression;
public void setExpression(Expression t){
this.expression=t;
if(single.get("expression")==null){single.put("expression",expression);}
}
private ParExpression parexpression;
public void setParExpression(ParExpression t){
this.parexpression=t;
if(single.get("parexpression")==null){single.put("parexpression",parexpression);}
}
private Statement statement;
public void setStatement(Statement t){
this.statement=t;
if(single.get("statement")==null){single.put("statement",statement);}
}
private Forstatement forstatement;
public void setForstatement(Forstatement t){
this.forstatement=t;
if(single.get("forstatement")==null){single.put("forstatement",forstatement);}
}
private Trystatement trystatement;
public void setTrystatement(Trystatement t){
this.trystatement=t;
if(single.get("trystatement")==null){single.put("trystatement",trystatement);}
}
private SwitchBlockStatementGroups switchblockstatementgroups;
public void setSwitchBlockStatementGroups(SwitchBlockStatementGroups t){
this.switchblockstatementgroups=t;
if(single.get("switchblockstatementgroups")==null){single.put("switchblockstatementgroups",switchblockstatementgroups);}
}
private String identifierStr;
public void setIDENTIFIER(String t){
this.identifierStr=t;
if(single.get("identifier")==null){single.put("identifier",identifierStr);}
}
private String semiStr;
public void setSEMI(String t){
this.semiStr=t;
if(single.get("semi")==null){single.put("semi",semiStr);}
}
public void visit(){
if(coz==0){
format="block";
}
if(coz==1){
format="'assert'  expression (':' expression)? ';'";
}
if(coz==2){
format="'if' parExpression statement ('else' statement)?";
}
if(coz==3){
format="forstatement";
}
if(coz==4){
format="'while' parExpression statement";
}
if(coz==5){
format="'do' statement 'while' parExpression ';'";
}
if(coz==6){
format="trystatement";
}
if(coz==7){
format="'switch' parExpression '{' switchBlockStatementGroups '}'";
}
if(coz==8){
format="'synchronized' parExpression block";
}
if(coz==9){
format="'return' expression? ';'";
}
if(coz==10){
format="'throw' expression ';'";
}
if(coz==11){
format="'break' IDENTIFIER? ';'";
}
if(coz==12){
format="'continue'IDENTIFIER? ';'";
}
if(coz==13){
format="expression  ';'";
}
if(coz==14){
format="IDENTIFIER ':' statement";
}
if(coz==15){
format="SEMI";
}
}
}
