package com.cozilyworks.util;

public class TestUtil{
	public static String ucword(String str){
		String begin=str.substring(0,1);
		String end=str.substring(1);
		return begin.toUpperCase()+end;
	}
}
