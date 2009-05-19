package com.cozilyworks.observer;

import java.util.Observer;

public class TestObServer {
	public static void main(String[] args) {
		Cat cat = new Cat();
		Mouse mouse = new Mouse();
		Observer person = new Person();
		cat.addObserver(mouse);
		cat.addObserver(person);
		cat.call();
	}
}