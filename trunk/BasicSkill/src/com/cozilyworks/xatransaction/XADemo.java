package com.cozilyworks.xatransaction;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.ConnectionEvent;
import javax.sql.ConnectionEventListener;
import javax.sql.XAConnection;
import javax.sql.XADataSource;
import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;

public class XADemo{
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
	public static XAConnection getXAConnetion(XADataSource dataSource){
		XAConnection XAConn=null;
		try{
			XAConn=dataSource.getXAConnection();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return XAConn;
	}
	public static Connection getConnection(XAConnection XAConn){
		Connection conn=null;
		try{
			conn=XAConn.getConnection();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeConnection(Connection conn){
		try{
			conn.close();
		}catch(SQLException e){
			System.out.println("fail");
		}
	}
	public static void main(String[] args) throws SQLException{
		System.out.println(XAResource.XA_OK+"=============");
		XADataSource dataSource1=XADemo.getXADataSource1();
		XAConnection xaCon1=XADemo.getXAConnetion(dataSource1);
		Connection con1=xaCon1.getConnection();
		Statement stmt1=con1.createStatement();
		MyXid xid1=new MyXid(1,new byte[]{0x01},new byte[]{0x02});
		XADataSource dataSource2=XADemo.getXADataSource2();
		
		XAConnection xaCon2=XADemo.getXAConnetion(dataSource2);
		Connection con2=xaCon2.getConnection();
		Statement stmt2=con2.createStatement();
		MyXid xid2=new MyXid(2,new byte[]{0x03},new byte[]{0x04});
		try{
			
			XAResource xaRes2=xaCon2.getXAResource();
			XAResource xaRes1=xaCon1.getXAResource();
			xaRes1.start(xid1,XAResource.TMNOFLAGS);
			xaRes2.start(xid2,XAResource.TMNOFLAGS);
			stmt1.executeUpdate("insert into test(username) values ('123')");
			stmt2.executeUpdate("insert into test(username) values ('william')");
			xaRes2.end(xid2,XAResource.TMSUCCESS);
			xaRes1.end(xid1,XAResource.TMSUCCESS);
			
			int ret1=xaRes1.prepare(xid1);
			int ret2=xaRes2.prepare(xid2);
			
			if(ret1==XAResource.XA_OK&&ret2==XAResource.XA_OK){
				xaRes1.commit(xid1,false);
				xaRes2.commit(xid2,false);
			}
		}catch(XAException e){
			e.printStackTrace();
		}finally{
			stmt1.close();
			con1.close();
			xaCon1.close();
			stmt2.close();
			con2.close();
			xaCon2.close();
		}
	}
}