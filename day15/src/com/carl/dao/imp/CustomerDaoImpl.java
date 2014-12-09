package com.carl.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.carl.dao.CustomerDao;
import com.carl.exception.DaoException;
import com.carl.exception.IdIsNullException;
import com.carl.model.Customer;
import com.carl.util.JdbcUtil;

public class CustomerDaoImpl implements CustomerDao {

	/*
	create table customer(
				id varchar(100) primary key,
				name varchar(200),
				gender varchar(10),
				birthday date,
				cellphone varchar(20),
				email varchar(200),
				hobby varchar(200),
				type varchar(100),
				description varchar(255)
			);
	 */
	@Override
	public void addCustomer(Customer c)  {
		if(c==null)
			throw new IllegalArgumentException();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("insert into customer (id,name,gender,birthday,cellphone,email,hobby,type,description) values(?,?,?,?,?,?,?,?,?)");
			stmt.setString(1,c.getId());
			stmt.setString(2, c.getName());
			stmt.setString(3,c.getGender());
			stmt.setDate(4, new java.sql.Date(c.getBirthday().getTime()));
			stmt.setString(5,c.getCellphone());
			stmt.setString(6, c.getEmail());
			stmt.setString(7,c.getHobby());
			stmt.setString(8, c.getType());
			stmt.setString(9,c.getDescription());
			stmt.executeUpdate();
		}catch(Exception e){
			throw new DaoException(e);
		}finally{
			JdbcUtil.release(rs, stmt, conn);
		}
	}

	@Override
	public void deleteCustomerById(String customerId) {
		if(customerId == null)
			throw new IllegalArgumentException();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("delete from customer where id=?");
			stmt.setString(1, customerId);
			stmt.executeUpdate();
		}catch(Exception e){
			throw new DaoException(e);
		}finally{
			JdbcUtil.release(rs, stmt, conn);
		}
	}

	@Override
	public void updateCustomer(Customer c) throws IdIsNullException {
		if(c==null)
			throw new IllegalArgumentException();
		if(c.getId()==null)
			throw new IdIsNullException("The customer's id can not be null");
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("update customer set name=?,gender=?,birthday=?,cellphone=?,email=?,hobby=?,type=?,description=? where id=?");
			stmt.setString(1, c.getName());
			stmt.setString(2,c.getGender());
			stmt.setDate(3, new java.sql.Date(c.getBirthday().getTime()));
			stmt.setString(4,c.getCellphone());
			stmt.setString(5, c.getEmail());
			stmt.setString(6,c.getHobby());
			stmt.setString(7, c.getType());
			stmt.setString(8,c.getDescription());
			stmt.setString(9,c.getId());
			stmt.executeUpdate();
		}catch(Exception e){
			throw new DaoException(e);
		}finally{
			JdbcUtil.release(rs, stmt, conn);
		}
	}

	@Override
	public List<Customer> findAll() {
		throw new AbstractMethodError("Can't invoke the abstract method");
	}

	@Override
	public Customer findCustomerById(String customerId) {
		if(customerId == null)
			throw new IllegalArgumentException();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("select * from customer where id=?");
			stmt.setString(1, customerId);
			rs = stmt.executeQuery();
			Customer c = new Customer();
			if(rs.next()){
				c.setId(rs.getString("id"));
				c.setName(rs.getString("name"));
				c.setGender(rs.getString("gender"));
				c.setCellphone(rs.getString("cellphone"));
				c.setDescription(rs.getString("description"));
				c.setEmail(rs.getString("email"));
				c.setHobby(rs.getString("hobby"));
				c.setType(rs.getString("type"));
				c.setBirthday(rs.getDate("birthday"));
				return c;
			}else{
				return null;
			}
		}catch(Exception e){
			throw new DaoException(e);
		}finally{
			JdbcUtil.release(rs, stmt, conn);
		}
	}

	@Override
	public int getTotalRecords() {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("select count(*) from customer"); 
			rs = stmt.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}else{
				return 0;
			}
		}catch(Exception e){
			throw new DaoException(e);
		}finally{
			JdbcUtil.release(rs, stmt, conn);
		}
	}

	@Override
	public List<Customer> findPageRecords(int startIndex, int pageSize) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		List<Customer> list = new ArrayList<Customer>();
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("select * from customer limit ?,?");
			stmt.setInt(1, startIndex);
			stmt.setInt(2, pageSize);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				Customer c = new Customer();
				c.setId(rs.getString("id"));
				c.setName(rs.getString("name"));
				c.setGender(rs.getString("gender"));
				c.setCellphone(rs.getString("cellphone"));
				c.setDescription(rs.getString("description"));
				c.setEmail(rs.getString("email"));
				c.setHobby(rs.getString("hobby"));
				c.setType(rs.getString("type"));
				c.setBirthday(rs.getDate("birthday"));
				list.add(c);
			}
			return list;
		}catch(Exception e){
			throw new DaoException(e);
		}finally{
			JdbcUtil.release(rs, stmt, conn);
		}
	}

}
