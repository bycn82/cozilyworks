package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class RelationalOp extends CodeDocument{
	private String ltStr;
	public void setLT(String t){
		this.ltStr=t;
	}
	private String eqStr;
	public void setEQ(String t){
		this.eqStr=t;
	}
	private String gtStr;
	public void setGT(String t){
		this.gtStr=t;
	}
	public void visit(){
		if(coz==0){
			// "LT EQ";
			format("%s%s",this.ltStr,this.eqStr);
		}
		if(coz==1){
			// "GT EQ";
			format("%s%s",this.gtStr,this.eqStr);
		}
		if(coz==2){
			// "LT";
			add(ltStr);
		}
		if(coz==3){
			// "GT";
			add(gtStr);
		}
	}
}
