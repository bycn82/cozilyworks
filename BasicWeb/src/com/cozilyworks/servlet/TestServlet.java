package com.cozilyworks.servlet;

import java.io.IOException;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.xfire.client.Client;
import com.caucho.hessian.client.HessianProxyFactory;
import com.cozilyworks.services.xfire.HelloService;
import com.cozilyworks.services.xfire.HelloServiceImpl;

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
		
		//client for xfire
		try{
			Client client=new Client(new URL(
				"http://127.0.0.1:8080/BasicWeb/services/HelloService?wsdl"));
			Object[] results=client.invoke("sayHello",new Object[]{"williamy"});
			System.out.println((String)results[0]);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//client for hessian
		String url="http://127.0.0.1:8080/BasicWeb/hello";
		HessianProxyFactory factory=new HessianProxyFactory();
		HelloService basic=(HelloService)factory.create(HelloService.class,url);
		System.out.println(basic.sayHello("william"));
	}
}