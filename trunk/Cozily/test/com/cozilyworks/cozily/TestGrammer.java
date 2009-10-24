package com.cozilyworks.cozily;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import com.cozilyworks.cozily.parser.CozilyLexer;
import com.cozilyworks.cozily.parser.CozilyParser;

public class TestGrammer{
	public static List<File> files=new ArrayList<File>();
	public static void main(String[] args) throws Exception{
		String path="D:\\WORKSPACES\\WORKS\\WalmartDal\\src";
		//path="E:\\TEMP\\org\\springframework\\aop\\aspectj\\autoproxy\\AspectJPrecedenceComparator.java";
		File f=new File(path);
		getAllJava(f);
		for(File file:files){
			test(file.getPath());
		}
	}
	private static void getAllJava(File f){
		if(f.isDirectory()){
			for(File file:f.listFiles())
				getAllJava(file);
		}else{
			if(f.getName().endsWith(".java")){
				files.add(f);
			}
		}
	}
	public static void test(String path) throws Exception{
		System.out.println(path.replace("\\","\\\\"));
		CozilyLexer lex=new CozilyLexer(new ANTLRFileStream(path));
		CommonTokenStream tokens=new CommonTokenStream(lex);
		CozilyParser g=new CozilyParser(tokens);
		try{
			g.fileDeclaration();
		}catch(RecognitionException e){
			e.printStackTrace();
		}
	}
}
