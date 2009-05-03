package com.cozilyworks.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: TestServlet
 */
public class TestServlet extends javax.servlet.http.HttpServlet{
	static final long serialVersionUID=1L;
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public TestServlet(){
		System.out.println("TestServlet construction method");
	}
	public void init(){
		System.out.println("init method in TestServlet");
	}
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
		System.out.println(request.getParameter("name")+" from doget()");
	}
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
		System.out.println(request.getParameter("name")+" from dopost()");
		doGet(request,response);
	}
}