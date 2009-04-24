package com.cozilyworks.cozily.compiler.codedom.statement;

import com.cozilyworks.cozily.compiler.codedom.Visitable;
import com.cozilyworks.cozily.compiler.codedom.expression.NewExpression;

public class DefineStatement implements Visitable {
	public String type;
	public String var;
	public NewExpression nexp;
	public String visit() {
		StringBuilder rtn = new StringBuilder();
		rtn.append(type).append(" ").append(var).append("=new ").append(nexp.visit()).append(";\n");
		return rtn.toString();
	}

}
