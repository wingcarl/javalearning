package com.carl.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.carl.util.JdbcUtil;

public class TransactionIsolationDemo {

	@Test
	public void test(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("select * from account where name='aaa'");
			rs = stmt.executeQuery();
			if(rs.next()){
				System.out.println("BEFROE:"+rs.getString("money"));
			}
			Thread.sleep(20*1000);
			stmt = conn.prepareStatement("select * from account where name='aaa'");
			rs = stmt.executeQuery();
			if(rs.next()){
				System.out.println("After:"+rs.getString("money"));
			}
		}catch(Exception e){
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			try {
				conn.commit();
			} catch (SQLException e) {
			}
			JdbcUtil.release(rs, stmt, conn);
		}
	}
}
