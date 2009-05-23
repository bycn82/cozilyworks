package com.cozly.pro.dao;

import java.util.List;
import com.cozilyworks.orm.dao.EntityDao;
import com.cozly.pro.entity.Account;

public interface UsersDao extends EntityDao<Account>{
	public void create(Account user);
	public void update(Account user);
	public void delete(Account user);
	public Account findAccountByUserNameAndEmail(String userName,String email);
	public String findMaxCozId();
}
