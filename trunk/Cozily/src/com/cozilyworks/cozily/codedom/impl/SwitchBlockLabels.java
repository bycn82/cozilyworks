package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class SwitchBlockLabels extends CodeDocument{
private List<SwitchCaseLabel> switchcaselabels=new ArrayList<SwitchCaseLabel>();
public void addSwitchCaseLabel(SwitchCaseLabel t){
this.switchcaselabels.add(t);
}
private SwitchDefaultLabel switchdefaultlabel2;
public void setSwitchDefaultLabel(SwitchDefaultLabel t){
this.switchdefaultlabel2=t;
}
}
