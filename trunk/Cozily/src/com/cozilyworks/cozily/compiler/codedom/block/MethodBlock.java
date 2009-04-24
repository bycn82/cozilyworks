package com.cozilyworks.cozily.compiler.codedom.block;

import java.util.ArrayList;
import java.util.List;

import com.cozilyworks.cozily.compiler.codedom.Visitable;
import com.cozilyworks.cozily.compiler.codedom.statement.DefineStatement;

public class MethodBlock implements Visitable {
	public String modifier;
	public String rtype;
	public String name;
	public List<DefineStatement> stmts=new ArrayList<DefineStatement>();
	public String visit() {
		StringBuilder rtn=new StringBuilder();
		rtn.append(modifier).append(" ").append(rtype).append(" ").append(name).append("(){");
		for(DefineStatement dstmt:stmts){
			rtn.append(dstmt.visit());
		}
		rtn.append("}\n");
		return rtn.toString();
	}

}
