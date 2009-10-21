package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class FileDeclaration extends CodeDocument{
private Annotations annotations;
public void setAnnotations(Annotations t){
this.annotations=t;
}
private PackageDeclaration packagedeclaration;
public void setPackageDeclaration(PackageDeclaration t){
this.packagedeclaration=t;
}
private List<ImportDeclaration> importdeclarations=new ArrayList<ImportDeclaration>();
public void addImportDeclaration(ImportDeclaration t){
this.importdeclarations.add(t);
}
private List<TypeDeclaration> typedeclarations=new ArrayList<TypeDeclaration>();
public void addTypeDeclaration(TypeDeclaration t){
this.typedeclarations.add(t);
}
public void visit(){
if(coz==0){
//"(annotations? packageDeclaration)? importDeclaration* typeDeclaration*";
}
}
}
