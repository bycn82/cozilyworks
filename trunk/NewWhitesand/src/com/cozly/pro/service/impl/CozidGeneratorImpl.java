package com.cozly.pro.service.impl;

import com.cozly.pro.dao.UsersDao;
import com.cozly.pro.service.CozidGenerator;

public class CozidGeneratorImpl implements CozidGenerator{
	private UsersDao usersdao;
	public String generateCozid(){
		String Header="Cozid-";
		String maxCozid=this.usersdao.findMaxCozId();
		maxCozid=maxCozid.replaceAll(Header,"");
		return Header+(Integer.parseInt(maxCozid)+1);
	}
	public void setUsersDao(UsersDao usersdao){
		this.usersdao=usersdao;
	}
}
