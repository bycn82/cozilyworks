package com.cozilyworks.cozily.sources;

import java.util.ArrayList;
import java.util.List;

public class SourceDescription{
	private String packageName;
	private List<String> imports=new ArrayList<String>();
	private List<String> symbols=new ArrayList<String>();;
	public String getPackageName(){
		return packageName;
	}
	public void setPackageName(String packageName){
		this.packageName=packageName;
	}
	public List<String> getImports(){
		return imports;
	}
	public void addImports(String str){
		this.imports.add(str);
	}
	public List<String> getSymbols(){
		return symbols;
	}
	public void addSymbols(String str){
		this.symbols.add(str);
	}
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append("package : ").append(packageName).append("\n");
		for(String imports:getImports()){
			sb.append("import : ").append(imports).append("\n");
		}
		for(String symbol:getSymbols()){
			sb.append("symbol : ").append(symbol).append("\n");
		}
		return sb.toString();
	}
}
