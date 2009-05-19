package com.cozilyworks.visitor;

public class FloatElement implements Visitable {
	private Float value;

	public FloatElement(Float value) {
		this.value = value;
	}

	public Float getValue() {
		return value;
	}

	// accept? ?
	public void accept(Visitor visitor) {
		visitor.visitFloat(this);
	}
}