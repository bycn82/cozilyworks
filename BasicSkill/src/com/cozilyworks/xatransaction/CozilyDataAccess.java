package com.cozilyworks.xatransaction;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Random;
import javax.sql.XAConnection;
import javax.sql.XADataSource;
import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;

public class CozilyDataAccess{
	private Random random=new Random();
	public HashMap<XAResource,CozilyXAID> resourcesAndId=new HashMap<XAResource,CozilyXAID>();
	public Statement createStatement(XADataSource dataSource1) throws SQLException{
		XAConnection xaCon1=getXAConnetion(dataSource1);
		Connection con1=xaCon1.getConnection();
		Statement stmt1=con1.createStatement();
		byte[] a=new byte[]{0x12},b=new byte[]{0x12};
		random.nextBytes(a);
		random.nextBytes(b);
		CozilyXAID xid2=new CozilyXAID(random.nextInt(),a,b);
		XAResource xaRes1=xaCon1.getXAResource();
		resourcesAndId.put(xaRes1,xid2);
		return stmt1;
	}
	public XAConnection getXAConnetion(XADataSource dataSource){
		XAConnection XAConn=null;
		try{
			XAConn=dataSource.getXAConnection();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return XAConn;
	}
	public void beginTransaction() throws XAException{
		for(XAResource xaRes:resourcesAndId.keySet()){
			xaRes.start(resourcesAndId.get(xaRes),XAResource.TMNOFLAGS);
		}
	}
	public void endTransaction() throws XAException{
		for(XAResource xaRes:resourcesAndId.keySet()){
			xaRes.end(resourcesAndId.get(xaRes),XAResource.TMSUCCESS);
		}
	}
	public void commit() throws XAException{
		int total=0;
		for(XAResource xaRes:resourcesAndId.keySet()){
			total+=xaRes.prepare(resourcesAndId.get(xaRes));
		}
		if(total==0){
			for(XAResource xaRes:resourcesAndId.keySet()){
				xaRes.commit(resourcesAndId.get(xaRes),false);
			}
		}
	}
}
class CozilyXAID implements Xid{
	private int formatId;
	private byte[] branchQualifier;
	private byte[] globalTransactionId;
	public CozilyXAID(int formatId,byte[] branchQualifier,byte[] globalTransactionId){
		this.formatId=formatId;
		this.branchQualifier=branchQualifier;
		this.globalTransactionId=globalTransactionId;
	}
	@Override
	public byte[] getBranchQualifier(){
		return globalTransactionId;
	}
	@Override
	public int getFormatId(){
		return formatId;
	}
	@Override
	public byte[] getGlobalTransactionId(){
		return branchQualifier;
	}
}
