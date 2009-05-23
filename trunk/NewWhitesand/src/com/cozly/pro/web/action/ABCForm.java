package com.cozly.pro.web.action;

import org.apache.struts.action.ActionForm;

public class ABCForm extends ActionForm{
	public String userName;

	public String getUserName(){
		return userName;
	}

	public void setUserName(String userName){
		this.userName=userName;
	}


}
