package com.cozilyworks.cozily.codedom;

public class CodeDocument{
	public boolean developing=false;
	public int coz=0;
	protected StringBuilder sb=new StringBuilder();
	protected String B=" ";
	protected String N="\n";
	protected String BN=" \n";
	protected String SEMI=";";
	protected String SEMIN=";\n";
	public String toString(){
		visit();
		if(sb.length()==0){
			if(developing){
				return "\n["+this.getClass().getSimpleName()+"]\n";
			}else{
				return " ";
			}
		}else{
			if(developing){
				return "\n["+this.getClass().getSimpleName()+"]->  "+sb.toString()+"\n";
			}else{
				return sb.toString();
			}
		}
	}
	public void visit(){
	}
	public void add(Object obj){
		if(obj!=null){
			sb.append(obj.toString());
		}
	}
	public void debug(Object obj){
		System.err.print("[DEBUG:]"+this.getClass().getSimpleName()+(obj!=null?obj.toString(): "null"));
	}
	public void b(){
		add(B);
	}
	public String show(){
		return sb.toString();
	}
	public void trace(String str){
		System.out.println(str);
	}
	public void trace(int i){
		trace(String.valueOf(i));
	}
	public void coz(){
		trace(coz);
	}
}
