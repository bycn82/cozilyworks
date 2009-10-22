package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class EqualOrNotequal extends CodeDocument{
	private String eqeqStr;
	public void setEQEQ(String t){
		this.eqeqStr=t;
	}
	private String bangeqStr;
	public void setBANGEQ(String t){
		this.bangeqStr=t;
	}
	public void visit(){
		if(coz==0){
			// "EQEQ";
			add(eqeqStr);
		}
		if(coz==1){
			// "BANGEQ";
			add(bangeqStr);
		}
	}
}
