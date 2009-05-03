package com.cozilyworks.taglib;

import java.io.IOException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTagOne extends SimpleTagSupport{
	public void doTag(){
		JspWriter out=this.getJspContext().getOut();
		try{
			out.println("extends SimpleTagSupport");
			//this.getJspBody().invoke(out);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
