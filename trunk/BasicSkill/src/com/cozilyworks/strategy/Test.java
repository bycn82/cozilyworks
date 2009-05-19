package com.cozilyworks.strategy;

public class Test {

	public static void main(String[] args) {

		float a = 200;
		float b = 25;

		ContextRole contextRole1 = new ContextRole(new AddStrategy());
		System.out.println(contextRole1.calculate(a, b));

		ContextRole contextRole2 = new ContextRole(new SubStrategy());
		System.out.println(contextRole2.calculate(a, b));

		ContextRole contextRole3 = new ContextRole(new MultStrategy());
		System.out.println(contextRole3.calculate(a, b));

		ContextRole contextRole4 = new ContextRole(new DivisionStrategy());
		System.out.println(contextRole4.calculate(a, b));
	}

}