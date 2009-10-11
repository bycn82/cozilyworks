package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class Statement extends CodeDocument{
private Block block1;
public void setBlock(Block t){
this.block1=t;
}
private String string2;
public void setASSERT(String t){
this.string2=t;
}
private Expression expression3;
public void setExpression(Expression t){
this.expression3=t;
}
private String string4;
public void setIF(String t){
this.string4=t;
}
private ParenthesizedExpression parenthesizedexpression5;
public void setParenthesizedExpression(ParenthesizedExpression t){
this.parenthesizedexpression5=t;
}
private Statement statement6;
public void setStatement(Statement t){
this.statement6=t;
}
private String string7;
public void setFOR(String t){
this.string7=t;
}
private ForInit forinit8;
public void setForInit(ForInit t){
this.forinit8=t;
}
private ForCondition forcondition9;
public void setForCondition(ForCondition t){
this.forcondition9=t;
}
private ForUpdater forupdater10;
public void setForUpdater(ForUpdater t){
this.forupdater10=t;
}
private LocalModifierList localmodifierlist11;
public void setLocalModifierList(LocalModifierList t){
this.localmodifierlist11=t;
}
private Type type12;
public void setType(Type t){
this.type12=t;
}
private String string13;
public void setIDENT(String t){
this.string13=t;
}
private String string14;
public void setWHILE(String t){
this.string14=t;
}
private String string15;
public void setDO(String t){
this.string15=t;
}
private String string16;
public void setTRY(String t){
this.string16=t;
}
private Catches catches17;
public void setCatches(Catches t){
this.catches17=t;
}
private String string18;
public void setSWITCH(String t){
this.string18=t;
}
private SwitchBlockLabels switchblocklabels19;
public void setSwitchBlockLabels(SwitchBlockLabels t){
this.switchblocklabels19=t;
}
private String string20;
public void setSYNCHRONIZED(String t){
this.string20=t;
}
private String string21;
public void setRETURN(String t){
this.string21=t;
}
private String string22;
public void setTHROW(String t){
this.string22=t;
}
private String string23;
public void setBREAK(String t){
this.string23=t;
}
private String string24;
public void setCONTINUE(String t){
this.string24=t;
}
private String string25;
public void setSEMI(String t){
this.string25=t;
}
}
