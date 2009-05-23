package com.cozly.pro.dao.impl;

import java.util.List;
import com.cozilyworks.orm.dao.hibernate.HibernateEntityDao;
import com.cozly.pro.dao.UsersDao;
import com.cozly.pro.entity.Account;



public class UsersDaoHibernateImpl extends HibernateEntityDao<Account> implements UsersDao{
	public void create(Account user){
		this.getHibernateTemplate().save(user);
	}
	public void delete(Account user){
		this.getHibernateTemplate().delete(user);
	}
	public void update(Account user){
		this.getHibernateTemplate().update(user);
	}
	public Account findAccountByUserNameAndEmail(String userName,String email){
		List result=this.getHibernateTemplate().find("from Account as a where a.Username= ? or a.Email =? ",new Object[]{userName,email});
		return result.size()>0?(Account)result.get(0):null;
	}
	public String findMaxCozId(){
		return (String)this.getHibernateTemplate().find("select max(a.Cozid) from Account as a").get(0);
		
	}
}
