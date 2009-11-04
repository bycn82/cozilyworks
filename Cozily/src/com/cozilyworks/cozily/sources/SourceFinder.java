package com.cozilyworks.cozily.sources;

import java.io.File;

public class SourceFinder{
	public Source findSource(String clzName){
		
		Source source=new Source();
		File file=new File(clzName+".java");
		if(file.exists()){
			System.err.println(clzName);
			source.setSourceFile(file);
			source.setTypeName(clzName);
			return source;
		}
		return null;
	}
}
