package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class Expression extends CodeDocument{
private ConditionalExpression conditionalexpression;
public void setConditionalExpression(ConditionalExpression t){
this.conditionalexpression=t;
if(single.get("conditionalexpression")==null){single.put("conditionalexpression",conditionalexpression);}
}
private AssignmentOperator assignmentoperator;
public void setAssignmentOperator(AssignmentOperator t){
this.assignmentoperator=t;
if(single.get("assignmentoperator")==null){single.put("assignmentoperator",assignmentoperator);}
}
private Expression expression;
public void setExpression(Expression t){
this.expression=t;
if(single.get("expression")==null){single.put("expression",expression);}
}
public void visit(){
if(coz==0){
format="conditionalExpression (assignmentOperator expression)?";
}
}
}
