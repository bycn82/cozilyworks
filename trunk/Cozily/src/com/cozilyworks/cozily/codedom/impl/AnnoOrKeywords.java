package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class AnnoOrKeywords extends CodeDocument{
private Annotation annotation;
public void setAnnotation(Annotation t){
this.annotation=t;
}
public void visit(){
if(coz==0){
//"annotation";
add(annotation);}
if(coz==1){
//"'public'";
add('public');}
if(coz==2){
//"'protected'";
add('protected');}
if(coz==3){
//"'private'";
add('private');}
if(coz==4){
//"'static'";
add('static');}
if(coz==5){
//"'abstract'";
add('abstract');}
if(coz==6){
//"'final'";
add('final');}
if(coz==7){
//"'native'";
add('native');}
if(coz==8){
//"'synchronized'";
add('synchronized');}
if(coz==9){
//"'transient'";
add('transient');}
if(coz==10){
//"'volatile'";
add('volatile');}
if(coz==11){
//"'strictfp'";
add('strictfp');}
}
}
