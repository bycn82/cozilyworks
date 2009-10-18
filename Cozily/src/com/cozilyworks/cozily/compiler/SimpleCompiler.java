package com.cozilyworks.cozily.compiler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.Arrays;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject.Kind;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import com.cozilyworks.cozily.parser.CozilyLexer;
import com.cozilyworks.cozily.parser.CozilyParser;
import com.cozilyworks.cozily.parser.CozilyTreeParser;

public class SimpleCompiler{
	public static String path="test\\Example.java";
	public static void main(String args[]) throws IOException, RecognitionException{
		File f=new File(path);
		String str=getParser(readFile(f).fileDeclaration().getTree()).fileDeclaration().toString();
		JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
		DiagnosticCollector<JavaFileObject> diagnostics=new DiagnosticCollector<JavaFileObject>();
		JavaFileObject file=new JavaSourceFromString("Example",str);
		Iterable<? extends JavaFileObject> compilationUnits=Arrays.asList(file);
		CompilationTask task=compiler.getTask(null,null,diagnostics,null,null,compilationUnits);
		boolean success=task.call();
		for(Diagnostic diagnostic:diagnostics.getDiagnostics()){
			System.out.println(diagnostic.getCode());
			System.out.println(diagnostic.getKind());
			System.out.println(diagnostic.getPosition());
			System.out.println(diagnostic.getStartPosition());
			System.out.println(diagnostic.getEndPosition());
			System.out.println(diagnostic.getSource());
			System.out.println(diagnostic.getMessage(null));
		}
		System.out.println("Success: "+success);
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

class JavaSourceFromString extends SimpleJavaFileObject{
	final String code;
	JavaSourceFromString(String name,String code){
		super(URI.create("string:///"+name.replace('.','/')+Kind.SOURCE.extension),Kind.SOURCE);
		this.code=code;
	}
	@Override
	public CharSequence getCharContent(boolean ignoreEncodingErrors){
		return code;
	}
}
