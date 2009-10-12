package com.cozilyworks.cozily.codedom;

public class CodeDocument{
	protected StringBuilder sb=new StringBuilder();
	protected String B=" ";
	protected String N="\n";
	protected String BN=" \n";
	protected String SEMI=";";
	protected String SEMIN=";\n";
	public String toString(){
		visit();
		if(sb.length()==0){
			return this.getClass().getSimpleName()+"\n";
		}else{
			return sb.toString();
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
}
