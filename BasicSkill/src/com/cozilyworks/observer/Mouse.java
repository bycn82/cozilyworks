package com.cozilyworks.observer;

import java.util.Observable;
import java.util.Observer;

public class Mouse implements Observer {
	public void update(Observable arg0, Object arg1) {
		System.out.println(arg1 + " run away");
	}
}