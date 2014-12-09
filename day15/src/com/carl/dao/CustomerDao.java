package com.carl.dao;

import java.util.List;

import com.carl.exception.IdIsNullException;
import com.carl.model.Customer;

public interface CustomerDao {
	void addCustomer(Customer c);
	void deleteCustomerById(String customerId);
	void updateCustomer(Customer c) throws IdIsNullException;
	List<Customer> findAll();
	Customer findCustomerById(String customerId);
	
	
}
