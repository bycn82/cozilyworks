package com.cozilyworks.strategy;

public class ContextRole {

	/**
	 * ??????????
	 */
	private AbstractStrategy abstactStrategy;

	public ContextRole(AbstractStrategy abstactStrategy) {
		this.abstactStrategy = abstactStrategy;
	}

	public String calculate(float a, float b) {
		String result = abstactStrategy.calculate(a, b);
		return result;
	}
}