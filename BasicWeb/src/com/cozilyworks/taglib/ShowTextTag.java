package com.cozilyworks.taglib;

import java.io.IOException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ShowTextTag extends SimpleTagSupport{
	public void doTag(){
		JspWriter out=this.getJspContext().getOut();
		try{
			out.println("extends SimpleTagSupport");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
