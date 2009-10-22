package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class Block extends CodeDocument{
	private List<BlockStatement> blockstatements=new ArrayList<BlockStatement>();
	public void addBlockStatement(BlockStatement t){
		this.blockstatements.add(t);
	}
	public void visit(){
		if(coz==0){
			// "'{' blockStatement* '}'";
			add("{");
			add(this.blockstatements);
			add("}");
		}
	}
}
