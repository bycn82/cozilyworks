package com.xa.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao2Impl implements UserDao2{
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate(){
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate=jdbcTemplate;
	}
	@Override
	public void insert(String name){
		System.out.println("22222");
		jdbcTemplate.execute("insert into test(username) values('"+name+"') ");
	}
}
