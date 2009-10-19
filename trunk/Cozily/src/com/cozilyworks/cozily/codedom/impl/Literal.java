package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class Literal extends CodeDocument{
private String intliteralStr;
public void setINTLITERAL(String t){
this.intliteralStr=t;
if(single.get("intliteral")==null){single.put("intliteral",intliteralStr);}
}
private String longliteralStr;
public void setLONGLITERAL(String t){
this.longliteralStr=t;
if(single.get("longliteral")==null){single.put("longliteral",longliteralStr);}
}
private String floatliteralStr;
public void setFLOATLITERAL(String t){
this.floatliteralStr=t;
if(single.get("floatliteral")==null){single.put("floatliteral",floatliteralStr);}
}
private String doubleliteralStr;
public void setDOUBLELITERAL(String t){
this.doubleliteralStr=t;
if(single.get("doubleliteral")==null){single.put("doubleliteral",doubleliteralStr);}
}
private String charliteralStr;
public void setCHARLITERAL(String t){
this.charliteralStr=t;
if(single.get("charliteral")==null){single.put("charliteral",charliteralStr);}
}
private String stringliteralStr;
public void setSTRINGLITERAL(String t){
this.stringliteralStr=t;
if(single.get("stringliteral")==null){single.put("stringliteral",stringliteralStr);}
}
private String trueStr;
public void setTRUE(String t){
this.trueStr=t;
if(single.get("true")==null){single.put("true",trueStr);}
}
private String falseStr;
public void setFALSE(String t){
this.falseStr=t;
if(single.get("false")==null){single.put("false",falseStr);}
}
private String nullStr;
public void setNULL(String t){
this.nullStr=t;
if(single.get("null")==null){single.put("null",nullStr);}
}
public void visit(){
if(coz==0){
format="INTLITERAL";
}
if(coz==1){
format="LONGLITERAL";
}
if(coz==2){
format="FLOATLITERAL";
}
if(coz==3){
format="DOUBLELITERAL";
}
if(coz==4){
format="CHARLITERAL";
}
if(coz==5){
format="STRINGLITERAL";
}
if(coz==6){
format="TRUE";
}
if(coz==7){
format="FALSE";
}
if(coz==8){
format="NULL";
}
}
}
