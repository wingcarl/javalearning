package com.carl.jdbc.pool;

import java.sql.Connection;

public class SimpleConncetionPoolClient {

	public static void main(String[] args){
		Connection c1 = SimpleConnectionPool.getConnection();
		Connection c2 = SimpleConnectionPool.getConnection();
		Connection c3 = SimpleConnectionPool.getConnection();
		SimpleConnectionPool.release(c1);
		SimpleConnectionPool.release(c3);
		SimpleConnectionPool.release(c2);

	}
}
