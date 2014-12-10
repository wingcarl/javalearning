package com.carl.jdbc.pool;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import com.carl.util.JdbcUtil;

public class SimpleConnectionPool {

	private static String driverClassName;
	private static String url;
	private static String user;
	private static String password;
	private static List<Connection> pool = new LinkedList<Connection>();
	static{
		try {
			InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties");
			Properties props = new Properties();
			props.load(in);
			driverClassName = props.getProperty("driverClassName");
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");
			Class.forName(driverClassName);
			//初始化10个链接
			for(int i=0;i<10;i++){
				Connection conn = DriverManager.getConnection(url, user, password);
				pool.add(conn);
			}
			System.out.println("初始化连接有:");
			for(Connection c:pool)
				System.out.println(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public synchronized static Connection getConnection(){
		if(pool.size()>0){
			Connection conn = pool.remove(0);
			System.out.println("取出的是:"+conn);
			System.out.println("还有:");
			for(Connection c:pool)
				System.out.println(c);
			return conn;
		}else{
			System.out.println("It's busy now");
			return null;
		}
	}
	public static void release(Connection conn){
		pool.add(conn);
		System.out.println("回来的是:"+conn);
		System.out.println("还有:");
		for(Connection c:pool)
			System.out.println(c);
	}
}
