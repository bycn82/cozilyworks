package com.cozilyworks.cozily.util;

public class StringUtilPlus{
	public static String ucword(String str){
		String begin=str.substring(0,1);
		String end=str.substring(1);
		return begin.toUpperCase()+end;
	}
	public static String getSuffixInt(String now){
		for(int i=0;i<now.length();i++){
			char c=now.charAt(now.length()-i-1);
			if(StringUtil.isUpperCase(c)){
				return now.substring(now.length()-i);
			}
		}
		return null;
	}
	/*
	 * v1中使用,有bug,过期了
	 */
	public static String setOrGetDependsOnNextOneOrTwoChar(int pos,String rule){
		String next=getNextOneChar(pos,rule);
		if(next!=null){
			if(next.equals("+")||next.equals("*")){
				return "add";
			}else{
				if(next.equals(")")){
					next=getNextOneChar(pos+1,rule);
					if(next!=null){
						if(next.equals("+")||next.equals("*")){
							return "add";
						}
					}
				}
			}
		}
		return "set";
	}
	public static String getNextOneChar(int pos,String rule){
		if(rule.length()>pos){
			String next=rule.substring(pos,pos+1);
			if(next.equals(" ")){
				return getNextOneChar(pos+1,rule);
			}else{
				return next;
			}
		}
		return null;
	}
	public static String clean(String tree){
		if(tree.indexOf("'")!=-1){
			int x=tree.indexOf("'");
			String left=tree.substring(0,x);
			String right=tree.substring(x+1);
			int y=right.indexOf("'");
			if(right.length()>=y+1){
				right=right.substring(y+1);
			}else{
				right="";
			}
			return left+clean(right);
		}else{
			return tree;
		}
	}
	/*
	 *
	 */
	public static String setOrAdd(int start,String rule){
		String c=getNextOneChar(start,rule);
		// 如果已经是最后的char 那么是set
		if(c==null){
			// the end
			return "set";
			// 如果后一个是* +都是add
		}else if(c.equals("*")||c.equals("+")){
			return "add";
		}else{
			// 都不是的情况需要比较复杂,需要计算)的个数,
			boolean complexAdd=checkRparens(start,rule);
			if(complexAdd){
				return "add";
			}
			return "set";
		}
	}/*
		* 如果第N个)后面是* +就是add,如果N是大于0的
		*/
	private static boolean checkRparens(int start,String rule){
		int n=0;
		for(int i=start;i<rule.length();i++){
			String c=rule.substring(i,i+1);
			// 碰到( 就n--
			if(c.equals("(")){
				n--;
			}
			// 碰到) 就n++
			if(c.equals(")")){
				n++;
				if(n>0){
					String tmp=getNextOneChar(i+1,rule);
					if(tmp!=null){
						if(tmp.equals("+")||tmp.equals("*")){
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	public static boolean notRule(int start,int end,String format){
		String c=StringUtil.lastChar(start,format);
		if(c!=null&&c.equals("'")){
			c=StringUtil.nextChar(end,format);
		}
		if(c!=null&&c.equals("'")){
			return true;
		}
		return false;
	}
	public static void main(String[] arg){
		String format="'package' qualifiedName ';'";
		System.out.println(parse(format));
	}
	public static String parse(String all){
		StringBuilder sb=new StringBuilder();
		Unit unit=getUnit(all);
		deal(unit);
		// 如果已经是全部了,就返回
		if(unit.getFormat().equals(all)){
			return unit.getResult();
		}else{
			// 不然就先做个标记,以后再替换
			String newAll=tag(all,unit);
			// 继续调用该函数
			return parse(newAll);
		}
	}
	private static String tag(String all,Unit unit){
		return null;
	}
	private static void deal(Unit unit){
		unit.setResult("["+unit.getFormat()+"]");
	}
	public static Unit getUnit(String all){
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
