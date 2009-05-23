package com.cozly.pro.service;

import com.cozly.pro.entity.Account;

public interface UserService{
	public void create(Account user);
	public void update(Account user);
	public void delete(Account user);
	public Account findByUserNameAndEmail(String userName ,String email);
	public int hasThisUserName(String userName);
	public int hasThisEmail(String email);
}
