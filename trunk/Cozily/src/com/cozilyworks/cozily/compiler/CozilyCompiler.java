package com.cozilyworks.cozily.compiler;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;
import com.cozilyworks.cozily.sources.Source;
import com.cozilyworks.cozily.sources.SourceManager;

/**
 * my compiler class ,which can compiler a source manager
 */
public class CozilyCompiler{
	public static void main(String[] args){
		System.out.println("Compiling..."+args[0]);
		Source source=new Source();
		//
		File file=new File(args[0]);
		source.setSourceFile(file);
		source.setTypeName(args[0]);
		
		SourceManager sourceManager=new SourceManager();
		sourceManager.newDepends(source);
		List<Source> sources=sourceManager.getSources();
		System.out.println(sources.size());
		compileSources(sources);
	}
	public static void compileSources(List<Source> sources){
		JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
		DiagnosticCollector<JavaFileObject> diagnostics=new DiagnosticCollector<JavaFileObject>();
		List<StringSource> compilationUnits=new ArrayList<StringSource>();
		for(Source source:sources){
			System.out.println(source.getContent());
			StringSource unit=new StringSource("A",source.getContent());
			compilationUnits.add(unit);
		}
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
}

class StringSource extends SimpleJavaFileObject{
	final String code;
	StringSource(String name,String code){
		super(URI.create("string:///"+name.replace('.','/')+Kind.SOURCE.extension),Kind.SOURCE);
		this.code=code;
	}
	@Override
	public CharSequence getCharContent(boolean ignoreEncodingErrors){
		return code;
	}
}
