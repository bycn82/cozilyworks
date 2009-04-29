package com.cozilyworks.cozily.codedom.impl;

import com.cozilyworks.cozily.codedom.SimpleElement;
import com.cozilyworks.cozily.codedom.Visitable;

public class PrimitiveType implements SimpleElement,Visitable{
	private String content;

	public PrimitiveType(String content) {
		this.content = content;
	}

	public String toString() {
		return this.content;
	}
}
