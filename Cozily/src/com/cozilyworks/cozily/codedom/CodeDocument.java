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
	public boolean developing=false;
	public int coz=0;
	protected StringBuilder sb=new StringBuilder();
	public HashMap single=new HashMap();
	public HashMap multi=new HashMap();
	public String format;
	public static Pattern pp=Pattern.compile("([A-Za-z0-9]+)");
	public int i=0;
	public HashMap<String,String> cozily=new HashMap<String,String>();
	public List<String> ckey=new ArrayList<String>();
	/**
	 * toString方法
	 */
	public String toString(){
		visit();
		String encoded=parse(format);
		sb.append(decode(encoded));
		return controlOutput();
	}
	private Object decode(String encoded){
		for(int i=ckey.size()-1;i>=0;i--){
			String key=ckey.get(i);
			String value=cozily.get(key);
			encoded=encoded.replace(key,value);
		}
		return encoded;
	}
	public String parse(String format){
		System.out.println(format);
		// 获取最小单元内容
		Unit unit=getMiniUnit(format);
		// 处理它
		deal(unit);
		// 如果已经是全部了,就返回
		if(unit.getFormat().equals(format)){
			return unit.getResult();
		}else{
			// 不然就先做个标记,以后再替换
			String newformat=tag(format,unit);
			// 继续调用该函数
			return parse(newformat);
		}
	}
	// 用标记替换取出的地方,然后把标记收集起来,以后要replace回来
	private String tag(String all,Unit unit){
		String tag="COZILY"+i;
		i++;
		cozily.put(tag,unit.getResult());
		ckey.add(tag);
		return all.replace(unit.getFormat(),tag);
	}
	// 处理,好复杂的,其中判断是单还是多,好像可以用Utils的那个setOrAdd
	public void deal(Unit unit){
		List args=new ArrayList();
		StringBuilder f=new StringBuilder();
		int start=0,end=0;
		String fstr=unit.getFormat();
		Matcher m=pp.matcher(fstr);
		while(m.find()){
			end=m.start();
			f.append(fstr.substring(start,end));
			String found=m.group();
			if(StringUtilPlus.notRule(m.start(),m.end(),unit.getFormat())||m.group().startsWith("COZILY")){
				f.append(found);
			}else{
				f.append("%s");
				if(unit.isSingle()){
					args.add(getSingle(m.group()));
				}else{
					args.add(getMulti(m.group()));
				}
			}
			start=m.end();
		}
		f.append(fstr.substring(start));
		String outcome=format(f,args,unit.isSingle());
		unit.setResult(outcome);
	}
	private String format(StringBuilder f,List args,boolean single){
		// System.out.println(this.getClass().getSimpleName()+"--->"+f.toString()+"   "+args.size()+single);
		StringBuilder outcome=new StringBuilder();
		if(single){
			outcome.append(String.format(f.toString(),args.toArray()));
		}else{
			int size=getTimes(args);
			for(int i=0;i<size;i++){
				List ls=new ArrayList();
				for(Object arg:args){
					Object obj=((List)arg).get(i);
					ls.add(obj);
				}
				Object ojs=ls.toArray();
				outcome.append(String.format(f.toString(),ojs));
			}
		}
		return outcome.toString();
	}
	public int getTimes(List args){
		int size=0;
		for(Object arg:args){
			if(arg!=null){
				try{
					size=((List)arg).size();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return size;
	}
	// 取出最小单元,就是取出第一个)对应的一对( )
	public Unit getMiniUnit(String all){
		Unit unit=new Unit();
		int i=all.indexOf(")");
		if(i!=-1){
			// 判断是多还是单
			String set=StringUtilPlus.setOrAdd(i,all);
			if(set.equals("set")){
				unit.setSingle(true);
			}else{
				unit.setSingle(false);
			}
			// 存在)号
			int start=0,end=i;
			// 取出)后面非空的第一个?*+ 如果不是空或者?*+,那么意思是没必要有这个)号,
			for(int k=i+1;k<all.length();k++){
				String next=StringUtil.nextChar(k,all);
				if(next.equals(" ")){
					continue;
				}
				if(next.equals("?")||next.equals("+")||next.equals("*")){
					end=k+1;
					break;
				}
			}
			// 取)前的第一个(,形成一对
			for(int k=i;k>1;k--){
				String last=StringUtil.lastChar(k,all);
				if(last.equals("(")){
					start=k-1;
					break;
				}
			}
			unit.setFormat(all.substring(start,end));
		}else{
			unit.setFormat(all);
			unit.setSingle(true);
		}
		return unit;
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
	// 设置Format
	public void visit(){}
	public void debug(Object obj){
		System.err.print("[DEBUG:]"+this.getClass().getSimpleName()+(obj!=null?obj.toString():"null"));
	}
	public String getSingle(String key){
		Object obj;
		if(StringUtil.isUpperCase(key,"_")){// String
			obj=single.get(key.toLowerCase());
		}else{
			obj=single.get(key.toLowerCase());
		}
		if(obj==null){
			return "_";
		}else{
			return obj.toString();
		}
	}
	public List getMulti(String key){
		List objs=(List)multi.get(key.toLowerCase());
		if(objs==null){
			return null;
		}
		return objs;
	}
}
class Unit{
	private String format;
	private boolean single;
	private String result;
	public void setResult(String r){
		result=r;
	}
	public String getResult(){
		return result;
	}
	public void setFormat(String f){
		format=f;
	}
	public String getFormat(){
		return format;
	}
	public boolean isSingle(){
		return single;
	}
	public void setSingle(boolean sing){
		single=sing;
	}
}
