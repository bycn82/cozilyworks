package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class Literal extends CodeDocument{
private String string1;
public void setHEX_LITERAL(String t){
this.string1=t;
}
private String string2;
public void setOCTAL_LITERAL(String t){
this.string2=t;
}
private String string3;
public void setDECIMAL_LITERAL(String t){
this.string3=t;
}
private String string4;
public void setFLOATING_POINT_LITERAL(String t){
this.string4=t;
}
private String string5;
public void setCHARACTER_LITERAL(String t){
this.string5=t;
}
private String string6;
public void setSTRING_LITERAL(String t){
this.string6=t;
}
private String string7;
public void setTRUE(String t){
this.string7=t;
}
private String string8;
public void setFALSE(String t){
this.string8=t;
}
private String string9;
public void setNULL(String t){
this.string9=t;
}
}
