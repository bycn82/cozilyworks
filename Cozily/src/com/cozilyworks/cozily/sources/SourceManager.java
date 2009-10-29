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
	private SymbolTable table=new SymbolTable();
	private List<Source> sources=new ArrayList<Source>();
	public List<Source> getSources(){
		return this.sources;
	}
	public void push(Source source){
		//1st, it's a new one for this manager
		if(!checkAlreadyHas(source)){

			append(source);
		}
	}
	/**
	 * check whether this manager alreayd contain this new one ,
	 * so need to check the type name ,and the path of file.
	 * @param Source
	 * @return
	 */
	private boolean checkAlreadyHas(Source nowSource){
		for(Source source:sources){
			if(source.getTypeName().equals(nowSource.getTypeName())){
				if(source.getSourceFile().getPath().equals(nowSource.getSourceFile().getPath())){
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * append this source into the list,
	 * so it's in the management
	 * @param source
	 */
	private void append(Source source){
		try{
			FileDeclaration fdec=parse(source);
			source.setContent(fdec.toString());
			sources.add(source);
		}catch(RecognitionException e){
			e.printStackTrace();
		}
	}
	/**
	 * parse the file with CozilyTreeParser and get the dependences
	 * @param source
	 * @return
	 * @throws RecognitionException
	 */
	private FileDeclaration parse(Source source) throws RecognitionException{
		return getParser(readFile(source.getSourceFile()).fileDeclaration().getTree()).fileDeclaration();
	}
	private CozilyParser readFile(File file){
		try{
			ANTLRInputStream input=new ANTLRInputStream(new FileInputStream(file));
			CozilyLexer lexer=new CozilyLexer(input);
			CommonTokenStream tokens=new CommonTokenStream(lexer);
			return new CozilyParser(tokens);
		}catch(Exception e){}
		return null;
	}
	private CozilyTreeParser getParser(Object o){
		CommonTreeNodeStream nodes=new CommonTreeNodeStream((CommonTree)o);
		return new CozilyTreeParser(nodes);
	}
}
