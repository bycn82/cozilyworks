package com.cozilyworks.strategy;
 public class MultStrategy extends AbstractStrategy{   
   
     public  String calculate(float a,float b){   
         float result = a*b;   
         return "mutl:" + result;   
     }   
 }   