package com.carl.service.impl;

import java.util.List;
import java.util.UUID;

import com.carl.dao.CustomerDao;
import com.carl.dao.imp.CustomerDaoImpl;
import com.carl.exception.IdIsNullException;
import com.carl.model.Customer;
import com.carl.model.Pager;
import com.carl.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{

	private CustomerDao dao = new CustomerDaoImpl();
	@Override
	public void addCustomer(Customer c) {
		c.setId(UUID.randomUUID().toString());
		dao.addCustomer(c);
	}

	@Override
	public void deleteCustomerById(String customerId) {
		dao.deleteCustomerById(customerId);
	}

	@Override
	public void updateCustomer(Customer c) throws IdIsNullException {
		dao.updateCustomer(c);
	}

	@Override
	public List<Customer> findAll() {
		return dao.findAll();
	}

	@Override
	public Customer findCustomerById(String customerId) {
		return dao.findCustomerById(customerId);
	}

	@Override
	public Pager findPageRecords(String pageNum) {
		int num = 1;
		if(pageNum != null && !"".equals(pageNum.trim())){
			num = Integer.parseInt(pageNum);
		}
		int totalRecords = dao.getTotalRecords();
		Pager page = new Pager(num,totalRecords);
		List records =  dao.findPageRecords(page.getStartIndex(), page.getPageSize());
		page.setRecords(records);
		return page;
	}

}
