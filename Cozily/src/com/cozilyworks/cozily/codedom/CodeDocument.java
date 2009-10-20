package com.cozilyworks.cozily.codedom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.cozilyworks.cozily.util.StringUtil;
import com.cozilyworks.cozily.util.StringUtilPlus;
public class CodeDocument{
	public static void main(String[] arg){
		CodeDocument c=new CodeDocument();
		c.format="((a? b)? c)* d* ";
		System.out.println(c);
	}
	public boolean developing=true;
	public int coz=0;
	protected StringBuilder sb=new StringBuilder();
	public HashMap single=new HashMap();
	public HashMap multi=new HashMap();
	public String format;
	public static Pattern pp=Pattern.compile("([A-Za-z0-9]+)");
	public int i=0;
	public HashMap<String,String> cozily=new HashMap<String,String>();
	public List<String> ckey=new ArrayList<String>();
	public String toString(){
		visit();
		String encoded=V(format);
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
	public String V(String format){
		// 获取最小的一个( )内容
		Unit unit=getMiniUnit(format);
		// 把这段小的替换成文本
		deal(unit);
		// 如果已经是全部了,就返回
		if(unit.getFormat().equals(format)){
			return unit.getResult();
		}else{
			// 不然就先做个标记,以后再替换
			String newformat=tag(format,unit);
			// 继续调用该函数
			return V(newformat);
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
	public static void deal(Unit unit){
		String str="";
		int start=0,end=0;
		String fstr=unit.getFormat();
		System.out.println("!!!! "+fstr);
		Matcher m=pp.matcher(fstr);
		System.out.println(m.groupCount());
		while(m.find()){
			end=m.start();
			str+=fstr.substring(start,end);
			str+=m.group().toUpperCase();
			start=m.end();
		}
		str+=fstr.substring(start);
		unit.setResult(str);
	}
	// 取出最小单元,就是取出第一个)对应的一对( )
	public static Unit getMiniUnit(String all){
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
	public void visit(){}
	public void debug(Object obj){
		System.err.print("[DEBUG:]"+this.getClass().getSimpleName()+(obj!=null?obj.toString():"null"));
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
