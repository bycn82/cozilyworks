package com.cozilyworks.builder;

public class MingGong implements Builder{
	public Fangzi f=new Fangzi();

	@Override
	public void buildWall() {
		f.wall="white wall ";
	}

	@Override
	public void buildWindow() {
		f.window="broken window ";
	}
	
}
