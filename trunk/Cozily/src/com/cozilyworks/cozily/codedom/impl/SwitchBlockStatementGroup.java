package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class SwitchBlockStatementGroup extends CodeDocument{
private SwitchLabel switchlabel;
public void setSwitchLabel(SwitchLabel t){
this.switchlabel=t;
}
private List<BlockStatement> blockstatements=new ArrayList<BlockStatement>();
public void addBlockStatement(BlockStatement t){
this.blockstatements.add(t);
}
}
