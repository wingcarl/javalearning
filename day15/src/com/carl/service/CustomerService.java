package com.carl.service;

import java.util.List;

import com.carl.exception.IdIsNullException;
import com.carl.model.Customer;
import com.carl.model.Pager;

public interface CustomerService {
	void addCustomer(Customer c);
	void deleteCustomerById(String customerId);
	void updateCustomer(Customer c) throws IdIsNullException;
	@Deprecated
	List<Customer> findAll();
	Customer findCustomerById(String customerId);
	Pager findPageRecords(String pageNum);
}
