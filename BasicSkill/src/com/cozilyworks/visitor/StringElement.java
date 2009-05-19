package com.cozilyworks.visitor;

public class StringElement implements Visitable {
	private String value;

	public StringElement(String string) {
		value = string;
	}

	public String getValue() {
		return value;
	}

	// accept? ?
	public void accept(Visitor visitor) {
		visitor.visitString(this);
	}
}