package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class SwitchBlockStatementGroup extends CodeDocument{
	public SwitchLabel switchlabel;
	public void setSwitchLabel(SwitchLabel t){
		this.switchlabel=t;
	}
	public List<BlockStatement> blockstatements=new ArrayList<BlockStatement>();
	public void addBlockStatement(BlockStatement t){
		this.blockstatements.add(t);
	}
	public void visit(){
		if(coz==0){
			//"switchLabel blockStatement*";
			add(this.switchlabel);
			adds(this.blockstatements);
		}
	}
}
