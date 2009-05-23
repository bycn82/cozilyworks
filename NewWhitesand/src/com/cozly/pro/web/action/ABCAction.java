package com.cozly.pro.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ABCAction extends Action{
	public ActionForward execute(ActionMapping mapping,ActionForm form,HttpServletRequest request,
		HttpServletResponse response) throws Exception{
		System.out.println("ABC see ya!");
		String name=((ABCForm)$(form)).getUserName();
		name=(String)super.$("userName");
		System.out.println(name);
		return new ActionForward("/test.jsp");
	}
}
