package com.cozilyworks.strategy;
 public class DivisionStrategy extends AbstractStrategy{   
   
     public  String calculate(float a,float b){   
         float result = a/b;   
         return "divi:" + result;   
     }   
 }  