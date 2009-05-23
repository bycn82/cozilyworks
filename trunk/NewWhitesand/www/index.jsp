<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:import url="/inc/toy.jsp"></c:import>
<c:import url="/inc/header.jsp"></c:import>
<c:choose>
	<c:when test="${empty logonUser}">
----------login 1----------
<form id="loginForm"
			action="${pageContext.request.contextPath}/account/logon.${ext}"
			method="post" enctype="multipart/form-data">userName: <input
			name="userName" value="" class="required"
			onmouseover="setEvent(this)" /> <br />
		password: <input name="password" value="" class="required"
			onmouseover="setEvent(this)" /> <br />
		<input name="file1" type="file" /> <br />
		<input type="reset" value="reset" /> <input type="submit"
			value="submit" /></form>
	</c:when>
	<c:otherwise>
	${logonUser.username }<br />
	</c:otherwise>
</c:choose>
-----------register--------

<form id="registForm"
	action="${pageContext.request.contextPath}/account/regist.${ext}"
	method="post">userName: <input name="userName" id="userNameId"
	value="" class="required" onmouseover="setEvent(this)" /> <span
	id="HasThisNameTip"></span> <br />
password: <input name="password1" id="password1" value=""
	onmouseover="setEvent(this)" /> <br />
again: <input name="password2" id="password2" value=""
	onmouseover="setEvent(this)" /> <span id="checkPasswordTip"></span> <br />
Email: <input id="email" name="email" value=""
	onmouseover="setEvent(this)" /> <span id="HasThisEmailTip"></span> <br />
计算下面结果当作验证码: <img src="${pageContext.request.contextPath}/getpic.${ext}" />
<br />
<input type="text" name="token" value="" /> <br />
<input type="submit" value="submit" /> <input type="reset"
	value="reset" /></form>



<c:import url="/inc/footer.jsp"></c:import>

<input id="from" type="textfield" name="from" value="${from}"
	class="required" />
<a href="#"
	onclick="showDateSelecter($('from'),$('to'),'start');return false;"
	HIDEFOCUS> <img
	src="${pageContext.request.contextPath}/images/icon/date_icon.gif"
	border="0" /> </a>
to
<input id="to" type="textfield" name="to" value="${to}" class="required" />
<a href="#"
	onclick="showDateSelecter($('from'),$('to'),'end');return false;"
	HIDEFOCUS> <img
	src="${pageContext.request.contextPath}/images/icon/date_icon.gif"
	border="0" /> </a>

<input id="to1" type="textfield" name="to1" value="${to1}"
	class="required" />
<a href="#"
	onclick="showDateSelecter($('to1'),'','single');return false;"
	HIDEFOCUS> <img
	src="${pageContext.request.contextPath}/images/icon/date_icon.gif"
	border="0" /> </a>

<script>

</script>
<br />

