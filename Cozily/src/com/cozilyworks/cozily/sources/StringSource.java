package com.cozilyworks.cozily.sources;
import java.net.URI;
import javax.tools.SimpleJavaFileObject;
import javax.tools.JavaFileObject.Kind;
public class StringSource extends SimpleJavaFileObject{
	final String code;
	public StringSource(String name,String code){
		super(URI.create("string:///"+name.replace('.','/')+Kind.SOURCE.extension),Kind.SOURCE);
		this.code=code;
	}
	@Override
	public CharSequence getCharContent(boolean ignoreEncodingErrors){
		return code;
	}
}