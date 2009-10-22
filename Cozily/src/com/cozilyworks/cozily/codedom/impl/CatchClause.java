package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class CatchClause extends CodeDocument{
	private FormalParameter formalparameter;
	public void setFormalParameter(FormalParameter t){
		this.formalparameter=t;
	}
	private Block block;
	public void setBlock(Block t){
		this.block=t;
	}
	public void visit(){
		if(coz==0){
			// "'catch' '(' formalParameter ')' block";
			format("catch( %s ) %s",this.formalparameter,this.block);
		}
	}
}
