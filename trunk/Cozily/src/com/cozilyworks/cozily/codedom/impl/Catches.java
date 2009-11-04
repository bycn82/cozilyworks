package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class Catches extends CodeDocument{
	public List<CatchClause> catchclauses=new ArrayList<CatchClause>();
	public void addCatchClause(CatchClause t){
		this.catchclauses.add(t);
	}
	public void visit(){
		if(coz==0){
			//"catchClause+";
			adds(this.catchclauses);
		}
	}
}
