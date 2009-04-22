package com.cozilyworks.cozily.compiler.codedom.expression;

import com.cozilyworks.cozily.compiler.codedom.Visitable;

public class NewExpression implements Visitable {

	public String type = "";
	public ParametersExpression pexp = null;

	public String visit() {
		StringBuilder rtn = new StringBuilder();
		if (!type.equalsIgnoreCase("")) {
			rtn.append("new "+type).append("("+(pexp!=null?pexp.visit():"")+")");
		}
		return rtn.toString();
	}

}
