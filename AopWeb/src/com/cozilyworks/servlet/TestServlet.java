package com.cozilyworks.servlet;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.cozilyworks.service.TestService;

public class TestServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		ServletContext application;
		WebApplicationContext wac;
		application=getServletContext();
		wac=WebApplicationContextUtils.getWebApplicationContext(application);
		TestService ts=(TestService)wac.getBean("testService");
		ts.getName();
		ts.getSize();
		ts.testAnno();
		resp.getWriter().println("OK");
	}
}
