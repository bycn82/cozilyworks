package com.xa.service;

import com.xa.dao.UserDao1;
import com.xa.dao.UserDao2;

public class UserServiceImpl implements UserService{
	public UserDao1 dao1;
	public UserDao2 dao2;
	@Override
	public void insertBothDatabase(int id,String name){
		dao1.insert(name);
		dao2.insert(name);
	}
	public UserDao1 getDao1(){
		return dao1;
	}
	public void setDao1(UserDao1 dao1){
		this.dao1=dao1;
	}
	public UserDao2 getDao2(){
		return dao2;
	}
	public void setDao2(UserDao2 dao2){
		this.dao2=dao2;
	}

}
