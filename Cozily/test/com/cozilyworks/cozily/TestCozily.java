package com.cozilyworks.cozily;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import com.cozilyworks.cozily.parser.CozilyLexer;
import com.cozilyworks.cozily.parser.CozilyParser;
import com.cozilyworks.cozily.parser.CozilyTreeParser;
public class TestCozily{
	public static List<File> files=new ArrayList<File>();
	public static void main(String[] args) throws RecognitionException{
		String path="test\\Example.java";
		// path="D:\\workspace";
		File f=new File(path);
		getAllJava(f);
		for(File file:files){
			trace(getParser(readFile(file).fileDeclaration().getTree()).fileDeclaration());
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
	public static CozilyParser readFile(File file){
		try{
			ANTLRInputStream input=new ANTLRInputStream(new FileInputStream(file));
			CozilyLexer lexer=new CozilyLexer(input);
			CommonTokenStream tokens=new CommonTokenStream(lexer);
			return new CozilyParser(tokens);
		}catch(Exception e){
			trace(e);
		}
		return null;
	}
	public static CozilyTreeParser getParser(Object o){
		CommonTreeNodeStream nodes=new CommonTreeNodeStream((CommonTree)o);
		return new CozilyTreeParser(nodes);
	}
	public static void trace(Object o){
		System.out.println(o);
	}
}
