package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class VariableDeclaratorList extends CodeDocument{
private List<VariableDeclarator> variabledeclarators=new ArrayList<VariableDeclarator>();
public void addVariableDeclarator(VariableDeclarator t){
this.variabledeclarators.add(t);
}
}
