package com.cozilyworks.cozily.codedom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.cozilyworks.cozily.util.StringUtil;
import com.cozilyworks.cozily.util.StringUtilPlus;

@SuppressWarnings("unchecked")
public class CodeDocument{
	public static boolean developing=false;
	public int coz=0;
	protected StringBuilder sb=new StringBuilder();
	public void visit(){}
	public void coz(){
		System.err.println(coz);
	}
	public void mark(){
		sb.append("COZILY");
	}
	public String toString(){
		visit();
		return ctrlOutput();
	}
	/**
	 * 简单地把对象加入
	 *
	 * @param obj
	 */
	protected void add(Object obj){
		if(obj!=null){
			sb.append(obj.toString());
		}
	}
	/**
	 * 循环地加入一个List里的所有对象
	 *
	 * @param objs
	 */
	protected void adds(List objs){
		if(objs!=null){
			for(int i=0;i<objs.size();i++){
				add(objs.get(i));
			}
		}
	}
	/**
	 * 如果对象非空,才会和格式一起输入
	 *
	 * @param format
	 * @param obj
	 */
	protected void add(String format,Object obj){
		if(obj!=null){
			sb.append(String.format(format,obj));
		}
	}
	/**
	 * 如果对象非空,才会和格式一起输入
	 *
	 * @param format
	 * @param objs
	 */
	protected void adds(String format,List objs){
		if(objs!=null){
			for(int i=0;i<objs.size();i++){
				add(format,objs.get(i));
			}
		}
	}
	/**
	 * 带格式的输入,如果参数为NULL,则用空格代替
	 *
	 * @param formatStr
	 * @param args
	 */
	protected void format(String formatStr,Object...args){
		int size=args.length;
		for(int i=0;i<size;i++){
			if(args[i]==null){
				args[i]="";
			}
		}
		add(String.format(formatStr,args));
	}
	/**
	 * 带格式输入,多次的,意思是 这个格式被输入N次
	 *
	 * @param formatStr
	 * @param lists
	 */
	protected void formats(String formatStr,List...lists){
		if(lists!=null){
			int size=lists[0].size();
			for(int i=0;i<size;i++){
				List args=new ArrayList();
				for(List ls:lists){
					args.add(ls.get(i));
				}
				add(String.format(formatStr,args.toArray()));
			}
		}
	}
	private String ctrlOutput(){
		if(sb.length()==0){
			if(developing){
				return "["+this.getClass().getSimpleName()+"]";
			}else{
				return "";
			}
		}else{
			if(developing){
				return "\n<"+this.getClass().getSimpleName()+">"+sb.toString()+"\n</"+this.getClass().getSimpleName()
					+">";
			}else{
				return sb.toString();
			}
		}
	}
	public void debug(Object obj){
		System.err.print("[DEBUG:]"+this.getClass().getSimpleName()+(obj!=null?obj.toString(): "null"));
	}
}
