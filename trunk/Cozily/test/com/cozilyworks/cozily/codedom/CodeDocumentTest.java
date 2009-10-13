package com.cozilyworks.cozily.codedom;

import junit.framework.TestCase;

public class CodeDocumentTest extends TestCase{
	private CodeDocument  cd=new CodeDocument();
	public void testAdd(){
		cd.add(" \n");
		System.out.println(cd.show().length());
	}
}
