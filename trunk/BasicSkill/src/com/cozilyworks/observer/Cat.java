package com.cozilyworks.observer;

import java.util.Observable;

public class Cat extends Observable {
	public void call() {
		this.setChanged();
		this.notifyObservers("cat speak\n");
	}
}