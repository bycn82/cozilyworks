package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class QualifiedIdentifier extends CodeDocument{
	private String id;
	public void setIDENT(String t){
		this.id=t;
	}
	private String dot;
	public void setDOT(String t){
		this.dot=t;
	}
	private QualifiedIdentifier qid;
	public void setQualifiedIdentifier(QualifiedIdentifier t){
		this.qid=t;
	}
	public void visit(){
		if(qid!=null){
			sb.append(qid).append(dot);
		}
		sb.append(id);
	}
}
