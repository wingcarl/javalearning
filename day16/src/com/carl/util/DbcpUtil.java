package com.carl.util;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;


public class DbcpUtil {
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
	
	public static Connection getConnection(){
		try{
			return ds.getConnection();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
}
