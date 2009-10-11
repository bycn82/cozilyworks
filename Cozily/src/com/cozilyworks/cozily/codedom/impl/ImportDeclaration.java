package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class ImportDeclaration extends CodeDocument{
	private String importStr;
	public void setIMPORT(String t){
		this.importStr=t;
	}
	private String staticStr;
	public void setSTATIC(String t){
		this.staticStr=t;
	}
	private QualifiedIdentifier qid;
	public void setQualifiedIdentifier(QualifiedIdentifier t){
		this.qid=t;
	}
	private String dotStar;
	public void setDOTSTAR(String t){
		this.dotStar=t;
	}
	public void visit(){
		sb.append(importStr).append(B);
		if(staticStr!=null){
			sb.append(staticStr);
		}
		sb.append(qid).append(dotStar).append(SEMIN);
	}
}
