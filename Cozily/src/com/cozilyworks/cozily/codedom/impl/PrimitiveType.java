package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class PrimitiveType extends CodeDocument{
	public void visit(){
		if(coz==0){
			//"'boolean'";
			add("boolean");
		}
		if(coz==1){
			//"'char'";
			add("char");
		}
		if(coz==2){
			//"'byte'";
			add("byte");
		}
		if(coz==3){
			//"'short'";
			add("short");
		}
		if(coz==4){
			//"'int'";
			add("int");
		}
		if(coz==5){
			//"'long'";
			add("long");
		}
		if(coz==6){
			//"'float'";
			add("float");
		}
		if(coz==7){
			//"'double'";
			add("double");
		}
	}
}
