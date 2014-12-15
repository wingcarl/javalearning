 package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.management.RuntimeErrorException;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;


public class TransactionUtil {

	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	private static DataSource ds;
	static{
		try{
			InputStream in = DbcpUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			Properties props = new Properties();
			props.load(in);
			ds = BasicDataSourceFactory.createDataSource(props);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static DataSource getDataSource(){
		return ds;
	}
	public static Connection getConnection(){
		try {
			Connection conn = tl.get();
			if (conn == null) {
				conn = ds.getConnection();
				tl.set(conn);
			}
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public void startTransaction(){
		try {
			Connection conn = tl.get();
			if (conn == null) {
				conn = getConnection();
			}
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public void rollback(){
		try {
			Connection conn = tl.get();
			if (conn == null) {
				conn = getConnection();
			}
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public void commit(){
		try {
			Connection conn = tl.get();
			if (conn == null) {
				conn = getConnection();
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public void release(){
		try {
			Connection conn = tl.get();
			if (conn != null) {
				conn.close();
				tl.remove();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
