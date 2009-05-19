package com.cozilyworks.strategy;

public class Calculate {

	public String getResult(float a, float b, char c) {

		float add = a + b;
		float sub = a - b;
		float mult = a * b;
		float division = a / b;

		switch (c) {
		case '+':
			return "plus:" + add;
		case '-':
			return "minus:" + sub;
		case '*':
			return "mult:" + mult;
		case '/':
			return "divi:" + division;
		default:
			return "something wrong";
		}
	}

}