package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class Modifier extends CodeDocument{
private String string1;
public void setPUBLIC(String t){
this.string1=t;
}
private String string2;
public void setPROTECTED(String t){
this.string2=t;
}
private String string3;
public void setPRIVATE(String t){
this.string3=t;
}
private String string4;
public void setSTATIC(String t){
this.string4=t;
}
private String string5;
public void setABSTRACT(String t){
this.string5=t;
}
private String string6;
public void setNATIVE(String t){
this.string6=t;
}
private String string7;
public void setSYNCHRONIZED(String t){
this.string7=t;
}
private String string8;
public void setTRANSIENT(String t){
this.string8=t;
}
private String string9;
public void setVOLATILE(String t){
this.string9=t;
}
private String string10;
public void setSTRICTFP(String t){
this.string10=t;
}
private LocalModifier localmodifier11;
public void setLocalModifier(LocalModifier t){
this.localmodifier11=t;
}
}
