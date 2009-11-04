package com.cozilyworks.cozily.sources;

import java.io.File;
import com.cozilyworks.cozily.codedom.impl.FileDeclaration;
import com.cozilyworks.cozily.codedom.impl.NormalClassDeclaration;
import com.cozilyworks.cozily.codedom.impl.TypeDeclaration;

/**
 * it's an
 * 
 * @author billyuan
 */
public class Source{
	private File sourceFile;
	private String typeName;
	private FileDeclaration fdec;
	private String content;
	public void change(){
		//fdec.
		content=fdec.toString();
	}
	public FileDeclaration getFdec(){
		return fdec;
	}
	public void setFdec(FileDeclaration fdec){
		this.fdec=fdec;
	}
	public String getContent(){
		return content;
	}
	public File getSourceFile(){
		return sourceFile;
	}
	public String getTypeName(){
		return typeName;
	}
	public void setSourceFile(File sourceFile){
		this.sourceFile=sourceFile;
	}
	public void setTypeName(String typeName){
		this.typeName=typeName;
	}
	public NormalClassDeclaration getNormalClassByName(String name){
		for(TypeDeclaration typeDec:fdec.typedeclarations){
			if(typeDec.classorinterfacedeclaration.classdeclaration.normalclassdeclaration.identifierStr.equals(name)){
				return typeDec.classorinterfacedeclaration.classdeclaration.normalclassdeclaration;
			}
		}
		return null;
	}
}
