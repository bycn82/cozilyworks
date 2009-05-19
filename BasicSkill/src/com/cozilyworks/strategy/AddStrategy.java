package com.cozilyworks.strategy;

public class AddStrategy extends AbstractStrategy {

	public String calculate(float a, float b) {
		float result = a + b;
		return "plus :" + result;
	}
}