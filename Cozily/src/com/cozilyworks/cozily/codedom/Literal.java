package com.cozilyworks.cozily.codedom;

public class Literal implements Visitable {
	private String content;

	public Literal(String content) {
		this.content = content;
	}

	public String toString() {
		return this.content;
	}
}
