package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class ClassBodyDeclaration extends CodeDocument{
	public String staticStr;
	public void setSTATIC(String t){
		this.staticStr=t;
	}
	public Block block;
	public void setBlock(Block t){
		this.block=t;
	}
	public MemberDecl memberdecl;
	public void setMemberDecl(MemberDecl t){
		this.memberdecl=t;
	}
	public void visit(){
		if(coz==0){
			//"';'";
			add(";");
		}
		if(coz==1){
			//"STATIC? block";
			add(this.staticStr);
			add(this.block);
		}
		if(coz==2){
			//"memberDecl";
			add(memberdecl);
		}
	}
}
