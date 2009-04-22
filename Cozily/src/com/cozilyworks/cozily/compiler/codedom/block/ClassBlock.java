package com.cozilyworks.cozily.compiler.codedom.block;

import java.util.ArrayList;
import java.util.List;

import com.cozilyworks.cozily.compiler.codedom.Visitable;

public class ClassBlock implements Visitable {
	public String modifier;
	public String name;
	public List<MethodBlock> mblocks=new ArrayList<MethodBlock>();
	public String visit() {
		StringBuilder rtn=new StringBuilder();
		rtn.append(modifier).append(" class ").append(name).append("{");
		for(MethodBlock mb:mblocks){
			rtn.append(mb.visit());
		}
		rtn.append("}");
		return rtn.toString();
	}

}