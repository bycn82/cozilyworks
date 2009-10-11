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
}
