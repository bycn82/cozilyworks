package com.cozly.pro.web.action;

import org.apache.struts.actions.MoldyAction;
import com.cozly.pro.service.CozidGenerator;
import com.cozly.pro.service.UserService;

public class BaseAction extends MoldyAction{
	protected UserService userservice;
	protected CozidGenerator cozidgenerator;
	public void setUserService(UserService userservice){
		this.userservice=userservice;
	}
	public void setCozidGenerator(CozidGenerator cozidgenerator){
		this.cozidgenerator=cozidgenerator;
	}
}
