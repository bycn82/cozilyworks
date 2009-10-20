package com.cozilyworks.cozily.util;
public class StringUtil{
	public static String camelStyle(String str){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<str.length();i++){
			char c=str.charAt(i);
			if(c=='_'){
				i++;
				c=str.charAt(i);
				sb.append(String.valueOf(c).toUpperCase());
			}else{
				sb.append(String.valueOf(c).toLowerCase());
			}
		}
		return sb.toString();
	}
	public static String unixStyle(String str){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<str.length();i++){
			char c=str.charAt(i);
			if(isUpperCase(c)){
				sb.append("_");
			}
			sb.append(String.valueOf(c).toLowerCase());
		}
		return sb.toString();
	}
	public static boolean isLowerCase(char c){
		return isLowerCase(String.valueOf(c),"");
	}
	public static boolean isLowerCase(String str){
		return isUpperCase(str,"");
	}
	public static boolean isLowerCase(String str,String except){
		for(int i=0;i<str.length();i++){
			char c=str.charAt(i);
			if(!except.contains(String.valueOf(c))){
				if((int)c>122||(int)c<97){
					return false;
				}
			}
		}
		return true;
	}
	public static boolean isUpperCase(char c){
		return isUpperCase(String.valueOf(c),"");
	}
	public static boolean isUpperCase(String str){
		return isUpperCase(str,"");
	}
	public static boolean isUpperCase(String str,String except){
		for(int i=0;i<str.length();i++){
			char c=str.charAt(i);
			if(!except.contains(String.valueOf(c))){
				if((int)c>90||(int)c<65){
					return false;
				}
			}
		}
		return true;
	}
	public static String nextChar(int pos,String str){
		return nextChar(pos,str,"");
	}
	public static String nextChar(int pos,String str,String except){
		if(str.length()>pos){
			String next=str.substring(pos,pos+1);
			if(except.contains(next)){
				return nextChar(pos+1,str,except);
			}else{
				return next;
			}
		}
		return null;
	}
	public static String lastChar(int pos,String str){
		return lastChar(pos,str,"");
	}
	public static String lastChar(int pos,String str,String except){
		if(pos>0){
			String next=str.substring(pos-1,pos);
			if(except.contains(next)){
				return lastChar(pos-1,str,except);
			}else{
				return next;
			}
		}
		return null;
	}
}
