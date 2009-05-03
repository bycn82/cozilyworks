<%@ page contentType="text/html; charset=GBK"%>
<%@ page
	import="com.cozilyworks.sessionbean.*,javax.naming.*,java.util.Properties"%>
<%
	Properties props=new Properties();
	props.setProperty("java.naming.factory.initial",
		"org.jnp.interfaces.NamingContextFactory");
	props.setProperty("java.naming.provider.url","localhost:1099");
	props.setProperty("java.naming.factory.url.pkgs","org.jboss.naming");
	InitialContext ctx;
	try{
		ctx=new InitialContext(props);
		Hello helloworld=(Hello)ctx.lookup("LocalStatelessBean/local");
		out.println(helloworld.SayHello("Bill"));
		helloworld=(Hello)ctx.lookup("RemoteStatelessBean/remote");
		out.println(helloworld.SayHello("Bill"));
		helloworld=(Hello)ctx.lookup("LocalStatefullBean/local");
		out.println(helloworld.SayHello("Bill"));
		helloworld=(Hello)ctx.lookup("RemoteStatefullBean/remote");
		out.println(helloworld.SayHello("Bill"));
	}catch(NamingException e){
		out.println(e.getMessage());
	}
%>
