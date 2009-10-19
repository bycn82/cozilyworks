package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class Modifier extends CodeDocument{
private Annotation annotation;
public void setAnnotation(Annotation t){
this.annotation=t;
if(single.get("annotation")==null){single.put("annotation",annotation);}
}
private String publicStr;
public void setPUBLIC(String t){
this.publicStr=t;
if(single.get("public")==null){single.put("public",publicStr);}
}
private String protectedStr;
public void setPROTECTED(String t){
this.protectedStr=t;
if(single.get("protected")==null){single.put("protected",protectedStr);}
}
private String privateStr;
public void setPRIVATE(String t){
this.privateStr=t;
if(single.get("private")==null){single.put("private",privateStr);}
}
private String staticStr;
public void setSTATIC(String t){
this.staticStr=t;
if(single.get("static")==null){single.put("static",staticStr);}
}
private String abstractStr;
public void setABSTRACT(String t){
this.abstractStr=t;
if(single.get("abstract")==null){single.put("abstract",abstractStr);}
}
private String finalStr;
public void setFINAL(String t){
this.finalStr=t;
if(single.get("final")==null){single.put("final",finalStr);}
}
private String nativeStr;
public void setNATIVE(String t){
this.nativeStr=t;
if(single.get("native")==null){single.put("native",nativeStr);}
}
private String synchronizedStr;
public void setSYNCHRONIZED(String t){
this.synchronizedStr=t;
if(single.get("synchronized")==null){single.put("synchronized",synchronizedStr);}
}
private String transientStr;
public void setTRANSIENT(String t){
this.transientStr=t;
if(single.get("transient")==null){single.put("transient",transientStr);}
}
private String volatileStr;
public void setVOLATILE(String t){
this.volatileStr=t;
if(single.get("volatile")==null){single.put("volatile",volatileStr);}
}
private String strictfpStr;
public void setSTRICTFP(String t){
this.strictfpStr=t;
if(single.get("strictfp")==null){single.put("strictfp",strictfpStr);}
}
public void visit(){
if(coz==0){
format="annotation";
}
if(coz==1){
format="PUBLIC";
}
if(coz==2){
format="PROTECTED";
}
if(coz==3){
format="PRIVATE";
}
if(coz==4){
format="STATIC";
}
if(coz==5){
format="ABSTRACT";
}
if(coz==6){
format="FINAL";
}
if(coz==7){
format="NATIVE";
}
if(coz==8){
format="SYNCHRONIZED";
}
if(coz==9){
format="TRANSIENT";
}
if(coz==10){
format="VOLATILE";
}
if(coz==11){
format="STRICTFP";
}
}
}
