package com.cozilyworks.servlet;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

@SuppressWarnings("serial")
public class TestGenericServlet extends GenericServlet{
	@Override
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException{
		
		System.out.print(((HttpServletRequest)req).getParameter("name"));
	}
}
