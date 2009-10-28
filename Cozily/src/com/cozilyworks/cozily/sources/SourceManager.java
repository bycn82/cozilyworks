package com.cozilyworks.cozily.sources;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import com.cozilyworks.cozily.codedom.impl.FileDeclaration;
import com.cozilyworks.cozily.parser.CozilyLexer;
import com.cozilyworks.cozily.parser.CozilyParser;
import com.cozilyworks.cozily.parser.CozilyTreeParser;

public class SourceManager{
	private List<Source> sources=new ArrayList<Source>();
	public List<Source> getSources(){
		return this.sources;
	}
	public SourceDescription newDepends(Source source){
		SourceDescription sd=new SourceDescription();
		try{
			FileDeclaration fdec=getParser(readFile(source.getSourceFile()).fileDeclaration().getTree()).fileDeclaration();
			sd=fdec.source;
			source.setContent(fdec.toString());
			sources.add(source);
		}catch(RecognitionException e){
			e.printStackTrace();
		}
		return sd;
	}
	private CozilyParser readFile(File file){
		try{
			ANTLRInputStream input=new ANTLRInputStream(new FileInputStream(file));
			CozilyLexer lexer=new CozilyLexer(input);
			CommonTokenStream tokens=new CommonTokenStream(lexer);
			return new CozilyParser(tokens);
		}catch(Exception e){
		}
		return null;
	}
	private CozilyTreeParser getParser(Object o){
		CommonTreeNodeStream nodes=new CommonTreeNodeStream((CommonTree)o);
		return new CozilyTreeParser(nodes);
	}
}
