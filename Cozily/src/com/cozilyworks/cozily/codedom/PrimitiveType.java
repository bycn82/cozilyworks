package com.cozilyworks.cozily.codedom;

public class PrimitiveType implements Visitable{
	private String content;

	public PrimitiveType(String content) {
		this.content = content;
	}

	public String toString() {
		return this.content;
	}
}
