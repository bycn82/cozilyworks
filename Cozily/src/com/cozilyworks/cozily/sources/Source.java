package com.cozilyworks.cozily.sources;
import java.io.File;
/**
 * it's an
 * @author billyuan
 *
 */
public class Source{
	private File sourceFile;
	private String typeName;
	private String content;
	public String getContent(){
		return content;
	}
	public File getSourceFile(){
		return sourceFile;
	}
	public String getTypeName(){
		return typeName;
	}
	public void setContent(String content){
		this.content=content;
	}
	public void setSourceFile(File sourceFile){
		this.sourceFile=sourceFile;
	}
	public void setTypeName(String typeName){
		this.typeName=typeName;
	}
}
