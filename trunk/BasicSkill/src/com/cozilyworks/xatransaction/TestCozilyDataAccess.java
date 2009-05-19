package com.cozilyworks.xatransaction;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.XADataSource;
import javax.transaction.xa.XAException;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;

public class TestCozilyDataAccess{
	public static void main(String[] arg) throws SQLException,XAException{
		CozilyDataAccess cda=new CozilyDataAccess();
		Statement stm1=cda.createStatement(getXADataSource1());
		Statement stm2=cda.createStatement(getXADataSource2());
		Statement stm3=cda.createStatement(getXADataSource2());
		cda.beginTransaction();
		stm1.executeUpdate("insert into test(username) values ('OK')");
		stm2.executeUpdate("insert into test(username) values ('william')");
		cda.endTransaction();
		cda.commit();
	}
	public static XADataSource getXADataSource1(){
		MysqlXADataSource dataSource=new MysqlXADataSource();
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	public static XADataSource getXADataSource2(){
		MysqlXADataSource dataSource=new MysqlXADataSource();
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/annatrainning");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		return dataSource;
	}
}
