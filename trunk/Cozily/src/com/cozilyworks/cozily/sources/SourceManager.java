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
import com.cozilyworks.cozily.syntax.MultiExtendFilterUtil;

public class SourceManager{
	private List<Source> sources=new ArrayList<Source>();
	private SourceFinder finder=new SourceFinder();
	public List<Source> getSources(){
		//及时加载依赖
		for(int i=sources.size()-1;i>=0;i--){
			sources.get(i).change();
			checkDependence(sources.get(i).getFdec().source);
		}
		//检测所有都toString了
		for(Source source:sources){
			if(source.getContent()==null){
				source.change();
			}
		}
		return this.sources;
	}
	private void checkDependence(SourceDescription sourceDec){
		//FIXME
		System.err.println(sourceDec);
		for(String symbol:sourceDec.getSymbols()){
			//如果找到source了
			Source source=finder.findSource(symbol);
			if(source!=null){
				push(source);
			}
		}
	}
	public void push(Source source){
		//1st, it's a new one for this manager
		if(!checkAlreadyHas(source)){
			append(source);
		}
	}
	/**
	 * check whether this manager alreayd contain this new one , so need to check the type name ,and the path of file.
	 * 
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
	 * append this source into the list, so it's in the management
	 * 
	 * @param source
	 */
	private void append(Source source){
		System.err.println("appending "+source.getTypeName());
		try{
			FileDeclaration fdec=parse(source);
			source.setFdec(fdec);
			sources.add(source);
			//检查多继承语法
			checkMultiExtend(source);
		}catch(RecognitionException e){
			e.printStackTrace();
		}
	}
	private void checkMultiExtend(Source source){
		//找到extendsTypeList里的类名
		List<String> clzNames=MultiExtendFilterUtil.getExtends(source);
		if(clzNames.size()>2){
			//多继承
			for(int i=1;i<clzNames.size()-1;i++){
				merge(source,clzNames.get(0),clzNames.get(i));
			}
		}
	}
	/**
	 * copy过来
	 */
	private void merge(Source targetSource,String string,String clzName){
		Source source=finder.findSource(clzName);
		append(source);
		MergeTool.merge(targetSource,string,source,clzName);
	}
	/**
	 * parse the file with CozilyTreeParser and get the dependences
	 * 
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
		}catch(Exception e){
		}
		return null;
	}
	private CozilyTreeParser getParser(Object o){
		CommonTreeNodeStream nodes=new CommonTreeNodeStream((CommonTree)o);
		return new CozilyTreeParser(nodes);
	}
}
