package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class EnumTopLevelScope extends CodeDocument{
private List<EnumConstant> enumconstants=new ArrayList<EnumConstant>();
public void addEnumConstant(EnumConstant t){
this.enumconstants.add(t);
}
private ClassTopLevelScope classtoplevelscope2;
public void setClassTopLevelScope(ClassTopLevelScope t){
this.classtoplevelscope2=t;
}
}
