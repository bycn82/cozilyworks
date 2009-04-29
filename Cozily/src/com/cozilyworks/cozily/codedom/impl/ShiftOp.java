package com.cozilyworks.cozily.codedom.impl;

import com.cozilyworks.cozily.codedom.SimpleElement;
import com.cozilyworks.cozily.codedom.Visitable;

public class ShiftOp implements SimpleElement,Visitable{
	private String content;
	public ShiftOp(String content){
		this.content=content;
	}
	public String toString(){
		return this.content;
	}
}
