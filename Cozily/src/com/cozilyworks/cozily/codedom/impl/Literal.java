package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class Literal extends CodeDocument{
	private String intliteralStr;
	public void setINTLITERAL(String t){
		this.intliteralStr=t;
	}
	private String longliteralStr;
	public void setLONGLITERAL(String t){
		this.longliteralStr=t;
	}
	private String floatliteralStr;
	public void setFLOATLITERAL(String t){
		this.floatliteralStr=t;
	}
	private String doubleliteralStr;
	public void setDOUBLELITERAL(String t){
		this.doubleliteralStr=t;
	}
	private String charliteralStr;
	public void setCHARLITERAL(String t){
		this.charliteralStr=t;
	}
	private String stringliteralStr;
	public void setSTRINGLITERAL(String t){
		this.stringliteralStr=t;
	}
	private String trueStr;
	public void setTRUE(String t){
		this.trueStr=t;
	}
	private String falseStr;
	public void setFALSE(String t){
		this.falseStr=t;
	}
	private String nullStr;
	public void setNULL(String t){
		this.nullStr=t;
	}
	public void visit(){
		if(coz==0){
			add(this.intliteralStr);
		}
		if(coz==1){
			add(this.longliteralStr);
		}
		if(coz==2){
			add(this.floatliteralStr);
		}
		if(coz==3){
			add(this.doubleliteralStr);
		}
		if(coz==4){
			add(this.charliteralStr);
		}
		if(coz==5){
			add(this.stringliteralStr);
		}
		if(coz==6){
			add(this.trueStr);
		}
		if(coz==7){
			add(this.falseStr);
		}
		if(coz==8){
			add(this.nullStr);
		}
	}
}
