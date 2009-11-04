package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class ClassCreatorRest extends CodeDocument{
	public Arguments arguments;
	public void setArguments(Arguments t){
		this.arguments=t;
	}
	public ClassBody classbody;
	public void setClassBody(ClassBody t){
		this.classbody=t;
	}
	public void visit(){
		if(coz==0){
			//"arguments classBody?";
			format("%s %s",this.arguments,this.classbody);
		}
	}
}
