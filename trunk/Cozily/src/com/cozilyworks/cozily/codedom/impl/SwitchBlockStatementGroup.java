package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class SwitchBlockStatementGroup extends CodeDocument{
private SwitchLabel switchlabel;
public void setSwitchLabel(SwitchLabel t){
this.switchlabel=t;
if(single.get("switchlabel")==null){single.put("switchlabel",switchlabel);}
}
private List<BlockStatement> blockstatements=new ArrayList<BlockStatement>();
public void addBlockStatement(BlockStatement t){
this.blockstatements.add(t);
if(multi.get("blockstatement")==null){multi.put("blockstatement",blockstatements);}
}
public void visit(){
if(coz==0){
format="switchLabel blockStatement*";
}
}
}
