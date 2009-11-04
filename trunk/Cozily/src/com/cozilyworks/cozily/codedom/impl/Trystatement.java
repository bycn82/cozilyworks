package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class Trystatement extends CodeDocument{
	public Block block;
	public void setBlock(Block t){
		this.block=t;
	}
	public Block block2;
	public void setBlock2(Block t){
		this.block2=t;
	}
	public Catches catches;
	public void setCatches(Catches t){
		this.catches=t;
	}
	public void visit(){
		if(coz==0){
			//"'try' block catches 'finally' block";
			format("try %s %s finally %s",this.block,this.catches,this.block2);
		}
		if(coz==1){
			//"'try' block catches";
			format("try %s %s",this.block,this.catches);
		}
		if(coz==2){
			//"'try' block 'finally' block";
			format("try %s finally %s",this.block,this.block2);
		}
	}
}
