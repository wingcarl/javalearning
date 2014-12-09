package com.carl.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.carl.dao.CustomerDao;
import com.carl.dao.imp.CustomerDaoImpl;
import com.carl.exception.IdIsNullException;
import com.carl.model.Customer;

public class CustomerDaoImplTest {

	private CustomerDao dao = new CustomerDaoImpl();
	@Test
	public void testAddCustomer() {
		Customer c = new Customer();
		c.setId(UUID.randomUUID().toString());
		c.setName("gfy");
		c.setBirthday(new Date());
		c.setCellphone("1993023");
		c.setDescription("aaa");
		c.setType("VIP");
		c.setGender("0");
		c.setEmail("122@sina.com");
		c.setHobby("³Ô·¹");
		dao.addCustomer(c);
	}

	@Test
	public void testDeleteCustomerById() {
		dao.deleteCustomerById("079d9e2d-0392-4be5-a32d-fd343a1339d2");
	}

	@Test
	public void testUpdateCustomer() throws IdIsNullException {
		Customer c = new Customer();
		c.setId("079d9e2d-0392-4be5-a32d-fd343a1339d2");
		c.setName("gfy");
		c.setBirthday(new Date());
		c.setCellphone("240392");
		c.setDescription("aaa");
		c.setType("VIP");
		c.setGender("0");
		c.setEmail("122@sina.com");
		c.setHobby("³Ô·¹");
		dao.updateCustomer(c);
	}
	
	@Test(expected = com.carl.exception.IdIsNullException.class)
	public void testUpdateCustomer1() throws IdIsNullException {
		Customer c = new Customer();
		dao.updateCustomer(c);
	}

	@Test
	public void testFindAll() {
		List<Customer> cs = dao.findAll();
		assertEquals(1,cs.size());
	}

	@Test
	public void testFindCustomerById() {
		Customer c = dao.findCustomerById("079d9e2d-0392-4be5-a32d-fd343a1339d2");
		assertNotNull(c);
		c = dao.findCustomerById("aaa");
		assertNull(c);
	}

}
