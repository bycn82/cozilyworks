package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;

public class Program{
	public List<Declaration> declarations=new ArrayList<Declaration>();
	public void addDeclaration(Declaration a){
		this.declarations.add(a);
	}
	public String toString(){
		StringBuilder sb=new StringBuilder();
		for(Declaration d:declarations)
			sb.append(d.toString());
		return sb.toString();
	}
}
