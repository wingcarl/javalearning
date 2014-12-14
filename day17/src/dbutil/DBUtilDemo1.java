package dbutil;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import util.DbcpUtil;

public class DBUtilDemo1 {

	private QueryRunner qr = new QueryRunner(DbcpUtil.getDataSource());
	@Test
	public void testAdd() throws SQLException {
		qr.update("insert into t1 (id,name,birthday) values(?,?,?)",1,"eee",new Date());
	}

	@Test
	public void testAdd1() throws SQLException {
		qr.update("insert into t1 (id,name,birthday) values(?,?,?)",2,"zql","1992-08-08");
	}
	
	@Test
	public void testAdd2() throws SQLException {
		qr.update("update t1 set birthday=? where id=?","1992-02-30",2);
	}
	
	@Test
	public void testBatch() throws SQLException {
		Object params[][] = new Object[10][];
		for(int i=0;i<10;i++){
			params[i] = new Object[]{i+3,"aaa"+(i+1),new Date()};
		}
		qr.batch("insert into t1 (id,name,birthday) values(?,?,?)", params);
	}
}
