package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class SwitchDefaultLabel extends CodeDocument{
private String string1;
public void setDEFAULT(String t){
this.string1=t;
}
private List<BlockStatement> blockstatements=new ArrayList<BlockStatement>();
public void addBlockStatement(BlockStatement t){
this.blockstatements.add(t);
}
}
