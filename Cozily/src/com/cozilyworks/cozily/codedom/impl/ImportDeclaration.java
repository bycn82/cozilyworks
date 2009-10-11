package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ImportDeclaration extends CodeDocument{
private String string1;
public void setIMPORT(String t){
this.string1=t;
}
private String string2;
public void setSTATIC(String t){
this.string2=t;
}
private QualifiedIdentifier qualifiedidentifier3;
public void setQualifiedIdentifier(QualifiedIdentifier t){
this.qualifiedidentifier3=t;
}
private String string4;
public void setDOTSTAR(String t){
this.string4=t;
}
}
