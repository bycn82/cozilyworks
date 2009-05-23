package com.cozly.pro.service.impl;


import java.util.List;
import com.cozly.pro.dao.UsersDao;
import com.cozly.pro.entity.Account;
import com.cozly.pro.service.UserService;

public class UserServiceImpl implements UserService{
	private UsersDao usersdao;
	public void setUsersDao(UsersDao usersdao){
		this.usersdao=usersdao;
	}
	public void update(Account user){
		this.usersdao.update(user);
	}
	public void create(Account user){
		this.usersdao.create(user);
	}
	public void delete(Account user){
		List<Account> ls=this.usersdao.getAll();
		System.out.println(ls.size());
		
		//this.usersdao.delete(user);
	}
	public Account findByUserNameAndEmail(String userName,String email){
		return this.usersdao.findAccountByUserNameAndEmail(userName,email);
	}
	public int hasThisUserName(String userName){
		Account a=this.usersdao.findAccountByUserNameAndEmail(userName,"");
		return a==null?0:1;
	}
	public int hasThisEmail(String email){
		Account a=this.usersdao.findAccountByUserNameAndEmail("",email);
		return a==null?0:1;
	}
}
