package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class FormalParameterDecls extends CodeDocument{
private EllipsisParameterDecl ellipsisparameterdecl;
public void setEllipsisParameterDecl(EllipsisParameterDecl t){
this.ellipsisparameterdecl=t;
if(single.get("ellipsisparameterdecl")==null){single.put("ellipsisparameterdecl",ellipsisparameterdecl);}
}
private NormalParameterDecl normalparameterdecl;
public void setNormalParameterDecl(NormalParameterDecl t){
this.normalparameterdecl=t;
if(single.get("normalparameterdecl")==null){single.put("normalparameterdecl",normalparameterdecl);}
}
private List<NormalParameterDecl> normalparameterdecls=new ArrayList<NormalParameterDecl>();
public void addNormalParameterDecl(NormalParameterDecl t){
this.normalparameterdecls.add(t);
if(multi.get("normalparameterdecl")==null){multi.put("normalparameterdecl",normalparameterdecls);}
}
public void visit(){
if(coz==0){
format="ellipsisParameterDecl";
}
if(coz==1){
format="normalParameterDecl (',' normalParameterDecl)*";
}
if(coz==2){
format="(normalParameterDecl ',')+ ellipsisParameterDecl";
}
}
}
