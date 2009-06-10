<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="mytag" uri="/WEB-INF/mytag.tld"%> 
<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="/WEB-INF/strtag.tld" prefix="str" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index jsp</title>
</head>
<body>
<br>------------------------------</br>
<form action="./servlet/com.cozilyworks.servlet.TestServlet?name=bill" method="post">
<input type="text" name="name" value="william"/>
<input type="submit" value="submit"/>
</form>
<br>------------------------------</br>
<br/>
<mytag:showtext/>
<br/>
<mytag:showdate/>
<br/>
<tags:page username="tag file"></tags:page>
<br>------------------------------</br>
<%
session=request.getSession();
session.setAttribute("name","william");
session.removeAttribute("name");

ServletContext context=getServletContext();
context.setAttribute("name","william");
context.removeAttribute("name");
%>
<br>------------------------------</br>
<br>
Replace #User with John<br>
<str:Replace oldStr="#User" newStr="John">
   <br> Dear #User,
   <str:Replace oldStr="#MyName" newStr="William">
nice to me you,my name is #MyName
	</str:Replace>
</str:Replace> 
<br>------------------------------</br>
<br><a href="TestGenericServlet?name=william">Generic Servlet</a>

<br>------------------------------</br>
<br>------------------------------</br>

</body>
</html>