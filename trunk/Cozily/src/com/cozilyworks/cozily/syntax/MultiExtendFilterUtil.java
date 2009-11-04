package com.cozilyworks.cozily.syntax;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.impl.ClassDeclaration;
import com.cozilyworks.cozily.codedom.impl.ClassOrInterfaceDeclaration;
import com.cozilyworks.cozily.codedom.impl.ExtendTypeList;
import com.cozilyworks.cozily.codedom.impl.FileDeclaration;
import com.cozilyworks.cozily.codedom.impl.NormalClassDeclaration;
import com.cozilyworks.cozily.codedom.impl.Type;
import com.cozilyworks.cozily.codedom.impl.TypeDeclaration;
import com.cozilyworks.cozily.codedom.impl.TypeList;
import com.cozilyworks.cozily.sources.Source;

public class MultiExtendFilterUtil{
	/**
	 * get all classes from the sources ,and put all the classes in the map and list,
	 */
	public static List<String> getExtends(Source source){
		List<String> classes=new ArrayList<String>();
		FileDeclaration fdec=source.getFdec();
		List<TypeDeclaration> typeDecs=fdec.typedeclarations;
		if(typeDecs!=null){
			for(TypeDeclaration typeDec:typeDecs){
				ClassOrInterfaceDeclaration CorIDec=typeDec.classorinterfacedeclaration;
				if(CorIDec!=null){
					ClassDeclaration classDec=CorIDec.classdeclaration;
					if(classDec!=null){
						NormalClassDeclaration normalClzDec=classDec.normalclassdeclaration;
						if(normalClzDec!=null){
							classes.add(normalClzDec.identifierStr);
							ExtendTypeList extendTypeList=normalClzDec.extendtypelist;
							if(extendTypeList!=null){
								TypeList typeList=extendTypeList.typelist;
								if(typeList!=null){
									classes.add(typeList.type.classorinterfacetype.identifierargs.identifierStr);
									List<Type> types=typeList.types;
									if(types.size()>0){
										int i=-1;;
										for(Type type:types){
											i++;
											classes.add(type.classorinterfacetype.identifierargs.identifierStr);
										}
										typeList.type=types.get(i);
										typeList.types=null;
									}
								}
							}
						}
					}
				}
			}
		}
		return classes;
	}
}
