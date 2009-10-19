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
		sb.append(V(format,single,multi));
		return controlOutput();
	}

	public String V(String format,HashMap<String,Object> single,HashMap<String,List<Object>> multi){
		//获取最小的一个( )内容
		String substr=getMiniUnit(format);
		
		//把这段小的替换成文本
		String cozStr=deal(substr,single,multi);
		//如果已经是全部了,就返回
		if(substr.equals(format)){
			return cozStr;
		}else{
			//不然就先做个标记,以后再替换
			String newformat=tag(format,cozStr);
			//继续调用该函数
			return V(newformat,single,multi);
		}
	}
	//用标记替换取出的地方,然后把标记收集起来,以后要replace回来
	private String tag(String format2,String cozStr){
		return null;
	}
	//处理,好复杂的,其中判断是单还是多,好像可以用Utils的那个setOrAdd
	private String deal(String substr,HashMap<String,Object> single2,HashMap<String,List<Object>> multi2){
		return null;
	}
	//取出最小单元,
	private String getMiniUnit(String format2){
		return null;
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
