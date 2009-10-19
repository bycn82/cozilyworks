package com.cozilyworks.cozily.codedom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CodeDocument{
	public boolean developing=true;
	public int coz=0;
	protected StringBuilder sb=new StringBuilder();
	public HashMap single=new HashMap();
	public HashMap multi=new HashMap();
	public String format;
	public String toString(){
		visit();
		V(format,single,multi);
		return controlOutput();
	}
	public void V(String format,HashMap<String,Object> single,HashMap<String,List<Object>> multi){
		System.out.println(format);
		
		System.out.println(single.size());
		System.out.println("====");
		System.out.println(multi.size());
	}
	private String controlOutput(){
		if(sb.length()==0){
			if(developing){
				return "\n["+this.getClass().getSimpleName()+"]\n";
			}else{
				return " ";
			}
		}else{
			if(developing){
				return "\n["+this.getClass().getSimpleName()+"]"+sb.toString();
			}else{
				return sb.toString();
			}
		}
	}
	public void visit(){
	}
	public void debug(Object obj){
		System.err.print("[DEBUG:]"+this.getClass().getSimpleName()+(obj!=null?obj.toString(): "null"));
	}
}
