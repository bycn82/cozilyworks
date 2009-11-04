package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class BlockOrSemi extends CodeDocument{
	public Block block;
	public void setBlock(Block t){
		this.block=t;
	}
	public void visit(){
		if(coz==0){
			//"block";
			add(block);
		}
		if(coz==1){
			//"';'";
			add(";");
		}
	}
}
