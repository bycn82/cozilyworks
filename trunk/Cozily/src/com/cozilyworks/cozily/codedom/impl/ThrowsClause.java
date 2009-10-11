package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class ThrowsClause extends CodeDocument{
private List<QualifiedIdentifier> qualifiedidentifiers=new ArrayList<QualifiedIdentifier>();
public void addQualifiedIdentifier(QualifiedIdentifier t){
this.qualifiedidentifiers.add(t);
}
}
