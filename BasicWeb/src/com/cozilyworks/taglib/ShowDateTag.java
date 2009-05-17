package com.cozilyworks.taglib;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class ShowDateTag extends TagSupport{
	@Override
	public int doEndTag() throws JspException{
		JspWriter out=this.pageContext.getOut();
		try{
			out.println("extends TagSupport from do endTag");
		}catch(IOException e){
			throw new JspException(e);
		}
		return EVAL_PAGE;
	}
	@Override
	public int doStartTag() throws JspException{
		JspWriter out=this.pageContext.getOut();
		try{
			out.println("extends TagSupport from do startTag");
		}catch(IOException e){
			throw new JspException(e);
		}
		return EVAL_PAGE;
	}
}