package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class SwitchBlockStatementGroups extends CodeDocument{
private List<SwitchBlockStatementGroup> switchblockstatementgroups=new ArrayList<SwitchBlockStatementGroup>();
public void addSwitchBlockStatementGroup(SwitchBlockStatementGroup t){
this.switchblockstatementgroups.add(t);
}
}
