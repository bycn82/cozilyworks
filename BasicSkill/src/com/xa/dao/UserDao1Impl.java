package com.xa.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao1Impl implements UserDao1{
	private JdbcTemplate jdbcTemplate;
	@Override
	public void insert(String name){
		System.out.println("1111111111");
		jdbcTemplate.execute("insert into test(username) values('"+name+"') ");
	}
	public JdbcTemplate getJdbcTemplate(){
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate=jdbcTemplate;
	}
}
