package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.Visitable;

public class TypeArguments implements Visitable {
	private List<TypeArgument> typeArgs=new ArrayList<TypeArgument>();
	public void add(TypeArgument tp){
		typeArgs.add(tp);
	}
}
