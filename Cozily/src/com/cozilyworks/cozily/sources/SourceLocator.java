package com.cozilyworks.cozily.sources;

public class SourceLocator{
	public static void main(String[] args){
		SourceLocator locator=new SourceLocator();
		locator.check("A");
	}

	private void check(String string){
		try{
			this.getClass().getClassLoader().loadClass("A");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}
