package com.cozilyworks.observer;

import java.util.Observable;
import java.util.Observer;

public class Person implements Observer {
	public void update(Observable arg0, Object arg1) {
		System.out.println(arg1 + "weak up"+arg0);
	}
}