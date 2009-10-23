package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ClassBodyDeclaration extends CodeDocument{
private String staticStr;
public void setSTATIC(String t){
this.staticStr=t;
}
private Block block;
public void setBlock(Block t){
this.block=t;
}
private MemberDecl memberdecl;
public void setMemberDecl(MemberDecl t){
this.memberdecl=t;
}
public void visit(){
if(coz==0){
//"';'";
}
if(coz==1){
//"STATIC? block";
}
if(coz==2){
//"memberDecl";
add(memberdecl);}
}
}
