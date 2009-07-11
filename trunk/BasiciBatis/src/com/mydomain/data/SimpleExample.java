package com.mydomain.data;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.ibatis.common.resources.Resources;
import com.mydomain.domain.Account;
import java.io.Reader;
import java.io.IOException;
import java.util.List;
import java.sql.SQLException;

public class SimpleExample{
	private static SqlMapClient sqlMapper;
	public static void main(String[] arg) throws SQLException{
		Account a=new Account();
		a.setFirstName("william");
		a.setLastName("yuan");
		a.setEmailAddress("cozly@hotmail.com");
		//insertAccount(a);
		
		List<Account> ls=selectAllAccounts();
		System.out.println(ls.size());
		a.setId(1);
		updateAccount(a);
		a.setId(2);
		deleteAccount(a);
		
	}
	static{
		try{
			Reader reader=Resources.getResourceAsReader("com/mydomain/data/SqlMapConfig.xml");
			sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		}catch(IOException e){
			// Fail fast.
			throw new RuntimeException("Something bad happened while building the SqlMapClient instance."+e,e);
		}
	}
	public static List selectAllAccounts() throws SQLException{
		return sqlMapper.queryForList("selectAllAccounts");
	}
	public static Account selectAccountById(int id) throws SQLException{
		return (Account)sqlMapper.queryForObject("selectAccountById",id);
	}
	public static void insertAccount(Account account) throws SQLException{
		sqlMapper.insert("insertAccount",account);
	}
	public static void updateAccount(Account account) throws SQLException{
		sqlMapper.update("updateAccount",account);
	}
	public static void deleteAccount(Account account) throws SQLException{
		sqlMapper.delete("deleteAccount",account);
	}
}
