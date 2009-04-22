package com.cozilyworks.cozily.compiler.codedom.expression;

import java.util.ArrayList;
import java.util.List;

import com.cozilyworks.cozily.compiler.codedom.Visitable;

public class ArgumentsExpression implements Visitable{
	public List<String> params = new ArrayList<String>();
	public List<String> vars = new ArrayList<String>();
	
	public String visit() {
		StringBuilder rtn = new StringBuilder();
		if (params.size() > 0) {
			for (int i = 0; i < params.size(); i++) {
				rtn.append(i == 1 ? "," : "").append(params.get(i)+" "+vars.get(i));
			}
		}
		return rtn.toString();
	}

}
