package com.cozilyworks.cozily;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import com.cozilyworks.cozily.codedom.CodeDocument;
import com.cozilyworks.cozily.codedom.impl.FileDeclaration;
import com.cozilyworks.cozily.parser.CozilyLexer;
import com.cozilyworks.cozily.parser.CozilyParser;
import com.cozilyworks.cozily.parser.CozilyTreeParser;

public class TestCozily{
	public static List<File> files=new ArrayList<File>();
	public static void main(String[] args) throws RecognitionException,IOException{
		String path="D:\\WORKSPACES\\WORKS\\NewWhitesand\\core\\org\\apache\\struts\\action";
		path="test\\Example.java";
		File f=new File(path);
		getAllJava(f);
		BufferedInputStream ins=new BufferedInputStream(System.in);
		for(File file:files){
			System.out.println(file.getPath());
			FileDeclaration fdec=getParser(readFile(file).fileDeclaration().getTree()).fileDeclaration();
			writeJAVA(fdec);
			System.err.println(fdec.source);
			fdec=getParser(readFile(file).fileDeclaration().getTree()).fileDeclaration();
			writeXML(fdec);
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
		}
		return null;
	}
	public static CozilyTreeParser getParser(Object o){
		CommonTreeNodeStream nodes=new CommonTreeNodeStream((CommonTree)o);
		return new CozilyTreeParser(nodes);
	}
	public static void writeJAVA(Object o){
		CodeDocument.developing=false;
		System.out.println(o);
	}
	public static void writeXML(Object o){
		CodeDocument.developing=true;
		File f=new File("output.xml");
		try{
			BufferedWriter w=new BufferedWriter(new FileWriter(f));
			w.write(o.toString());
			w.flush();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
