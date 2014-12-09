package com.carl.dao;

import java.util.List;

import com.carl.exception.IdIsNullException;
import com.carl.model.Customer;

public interface CustomerDao {
	void addCustomer(Customer c);
	void deleteCustomerById(String customerId);
	void updateCustomer(Customer c) throws IdIsNullException;
	@Deprecated
	List<Customer> findAll();
	Customer findCustomerById(String customerId);
	//���������ҳ�йص�
	int getTotalRecords();
	/**
	 * Query pager number
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	List<Customer> findPageRecords(int startIndex,int pageSize);
	
}