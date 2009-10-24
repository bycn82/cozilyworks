package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class Modifiers extends CodeDocument{
	private List<AnnoOrKeywords> annoorkeywordss=new ArrayList<AnnoOrKeywords>();
	public void addAnnoOrKeywords(AnnoOrKeywords t){
		this.annoorkeywordss.add(t);
	}
	public void visit(){
		if(coz==0){
			//"annoOrKeywords*";
			adds(this.annoorkeywordss);
		}
	}
}
