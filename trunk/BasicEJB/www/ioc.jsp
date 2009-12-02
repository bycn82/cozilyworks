<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.cozilyworks.ioc.*, javax.naming.*,java.util.Properties"%>
<%
  Properties props=new Properties();
	props.setProperty("java.naming.factory.initial",
		"org.jnp.interfaces.NamingContextFactory");
	props.setProperty("java.naming.provider.url","localhost:1099");
	props.setProperty("java.naming.factory.url.pkgs","org.jboss.naming");
	InitialContext ctx;
	try{
	ctx = new InitialContext();
		Injection injection = (Injection) ctx.lookup("InjectionBean/remote");
		out.println(injection.SayHello());
	} catch (NamingException e) {
		out.println(e.getMessage());
	}
%>
