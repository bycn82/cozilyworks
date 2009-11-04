package com.cozilyworks.cozily.sources;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.impl.ClassBodyDeclaration;
import com.cozilyworks.cozily.codedom.impl.MethodDeclaration;
import com.cozilyworks.cozily.codedom.impl.NormalClassDeclaration;

public class MergeTool{
	/**
	 * 不是什么都copy哦
	 */
	public static void merge(Source targetSource,String name,Source source,String clzName){
		System.err.println("push all methods from "+clzName+" to "+name);
		NormalClassDeclaration to=targetSource.getNormalClassByName(name);
		NormalClassDeclaration from=source.getNormalClassByName(clzName);
		List<MethodDeclaration> methods=new ArrayList<MethodDeclaration>();
		for(ClassBodyDeclaration clzBodyDec:to.classbody.classbodydeclarations){
			methods.add(clzBodyDec.memberdecl.methoddeclaration);
		}
		for(ClassBodyDeclaration clzBodyDec:from.classbody.classbodydeclarations){
			if(!has(methods,clzBodyDec)){
				to.classbody.classbodydeclarations.add((ClassBodyDeclaration)clzBodyDec.clone());
			}
		}
	}

	private static boolean has(List<MethodDeclaration> methods,ClassBodyDeclaration clzBodyDec){
		for(MethodDeclaration methodDec:methods){
			if(methodDec.identifierStr.equals(clzBodyDec.memberdecl.methoddeclaration.identifierStr)){
				return true;
			}
		}
		return false;
	}
}
