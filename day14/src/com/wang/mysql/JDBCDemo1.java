package com.wang.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Driver;


public class JDBCDemo1 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		//DriverManager.registerDriver(new Driver());//不可取,严重依赖具体的数据库驱动
		Class.forName("com.mysql.jdbc.Driver");
		//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fz_sci","root","4542212");
		Properties info = new Properties();
		info.setProperty("user","root");
		info.setProperty("password", "4542212");
		Connection conn = DriverManager.getConnection("jdbc:mysql:///fz_sci",info);
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select id,name from t_dept");
		while(rs.next()){
			System.out.println("----------------");
			System.out.println(rs.getObject("id"));
			System.out.println(rs.getObject("name"));
		}
		rs.close();
		stmt.close();
		conn.close();
	}
}
