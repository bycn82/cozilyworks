package com.cozilyworks.builder;

public class Director {

	private Builder builder;

	public Director(Builder builder) {
		this.builder = builder;
	}

	// ?partA partB partC
	// ?
	public void construct() {
		builder.buildWall();
		builder.buildWindow();
	}

}