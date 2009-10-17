package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class Creator extends CodeDocument{
private NonWildcardTypeArguments nonwildcardtypearguments;
public void setNonWildcardTypeArguments(NonWildcardTypeArguments t){
this.nonwildcardtypearguments=t;
}
private ClassOrInterfaceType classorinterfacetype;
public void setClassOrInterfaceType(ClassOrInterfaceType t){
this.classorinterfacetype=t;
}
private ClassCreatorRest classcreatorrest;
public void setClassCreatorRest(ClassCreatorRest t){
this.classcreatorrest=t;
}
private ArrayCreator arraycreator;
public void setArrayCreator(ArrayCreator t){
this.arraycreator=t;
}
}
