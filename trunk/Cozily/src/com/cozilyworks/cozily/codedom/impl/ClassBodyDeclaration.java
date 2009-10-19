package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ClassBodyDeclaration extends CodeDocument{
private String staticStr;
public void setSTATIC(String t){
this.staticStr=t;
if(single.get("static")==null){single.put("static",staticStr);}
}
private Block block;
public void setBlock(Block t){
this.block=t;
if(single.get("block")==null){single.put("block",block);}
}
private MemberDecl memberdecl;
public void setMemberDecl(MemberDecl t){
this.memberdecl=t;
if(single.get("memberdecl")==null){single.put("memberdecl",memberdecl);}
}
public void visit(){
if(coz==0){
format="';'";
}
if(coz==1){
format="STATIC? block";
}
if(coz==2){
format="memberDecl";
}
}
}
