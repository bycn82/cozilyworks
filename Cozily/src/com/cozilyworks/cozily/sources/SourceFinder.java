package com.cozilyworks.cozily.sources;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SourceFinder{
	/*
	 * 找到所有依赖的文件
	 */
	public List<String> findSource(SourceDescription desc){
		List<String> symbols=desc.getSymbols();
		String nowPackage=desc.getPackageName();
		//TODO check class can be loaded
		return findJavaSource(nowPackage,desc);
	}
	private List<String> findJavaSource(String nowPackage, SourceDescription desc){
		List<String> paths=new ArrayList<String>();
		for(String symbol:desc.getSymbols()){
			String path=symbol+".java";
			File f=new File(path);
			if(f.exists()){
				paths.add(f.getName());
			}
		}
		return paths;
	}
	private boolean canBeLoaded(String string){
		try{
			this.getClass().getClassLoader().loadClass("A");
			return true;
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			return false;
		}
	}
}
