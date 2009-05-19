package com.cozilyworks.strategy;
 public class SubStrategy extends AbstractStrategy{   
   
     public  String calculate(float a,float b){   
         float result = a-b;   
         return "minus:" + result;   
     }   
 }   