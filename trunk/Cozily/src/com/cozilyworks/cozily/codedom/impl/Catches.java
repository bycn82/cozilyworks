package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class Catches extends CodeDocument{
private List<CatchClause> catchclauses=new ArrayList<CatchClause>();
public void addCatchClause(CatchClause t){
this.catchclauses.add(t);
if(multi.get("catchclause")==null){multi.put("catchclause",catchclauses);}
}
public void visit(){
if(coz==0){
format="catchClause+";
}
}
}
