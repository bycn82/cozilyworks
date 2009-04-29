package com.cozilyworks.cozily.codedom.impl;

import com.cozilyworks.cozily.codedom.SimpleElement;
import com.cozilyworks.cozily.codedom.Visitable;

public class Literal implements SimpleElement,Visitable {
	private String content;

	public Literal(String content) {
		this.content = content;
	}

	public String toString() {
		return this.content;
	}
}
