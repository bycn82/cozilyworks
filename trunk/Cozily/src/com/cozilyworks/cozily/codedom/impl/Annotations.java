package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class Annotations extends CodeDocument{
private List<Annotation> annotations=new ArrayList<Annotation>();
public void addAnnotation(Annotation t){
this.annotations.add(t);
if(multi.get("annotation")==null){multi.put("annotation",annotations);}
}
public void visit(){
if(coz==0){
format="annotation+";
}
}
}
