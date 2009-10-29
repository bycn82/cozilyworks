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
import com.cozilyworks.cozily.sources.SourceDescription;
import com.cozilyworks.cozily.sources.SourceManager;
import com.cozilyworks.cozily.sources.StringSource;
/**
 * my compiler class ,which can compiler a source manager
 */
public class CozilyCompiler{
	public static void main(String[] args){
		SourceManager sourceManager=new SourceManager();
		for(String str:args){
			System.out.println("<<"+str);
			Source source=new Source();
			File file=new File(str);
			source.setSourceFile(file);
			source.setTypeName(str.replace(".java",""));
			sourceManager.push(source);
		}
		System.out.println("Starting Cozily Compiler...");
		List<Source> sources=sourceManager.getSources();
		compileSources(sources);
	}
	public static void compileSources(List<Source> sources){
		JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
		DiagnosticCollector<JavaFileObject> diagnostics=new DiagnosticCollector<JavaFileObject>();
		List<StringSource> compilationUnits=new ArrayList<StringSource>();
		for(Source source:sources){
			System.out.println("------"+source.getContent());
			StringSource unit=new StringSource(source.getTypeName(),source.getContent());
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
