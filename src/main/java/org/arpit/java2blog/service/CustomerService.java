package org.arpit.java2blog.service;

import java.util.List;

import javax.transaction.Transactional;

import org.arpit.java2blog.dao.CustomerDao;
import org.arpit.java2blog.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("customerService")
public class CustomerService {

	@Autowired
	CustomerDao customerDao;

	@Transactional
	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}

	@Transactional
	public Customer getCustomer(int id) {
		return customerDao.getCustomer(id);
	}

	@Transactional
	public void addCustomer(Customer customer) {
		if(customer.getCustomerName() == "") {
			customer.setCustomerName("Adminuser");
		}
		if(!customer.getEmail().contains("@gmail.com") ) {
			customer.setEmail(customer.getEmail().concat("@gmail.in"));
		}
		if(customer.getCountry().equalsIgnoreCase("India")) {
			customer.setCountry("+91 ".concat(customer.getCountry()));
		}
		else if(customer.getCountry().equalsIgnoreCase("UK")) {
			customer.setCountry("+01 " + customer.getCountry());
		}
		else {
			customer.setCountry("+08 " + customer.getCountry());
		}
		
		String Age = customer.getAge();
		int a = Integer.parseInt(Age);
		if(a>=18) {
			customer.setAge("Major Customer");
		}
		else {
			customer.setAge("Minor Customer");
		}
			{
		customerDao.addCustomer(customer);
	}
	}
	

	@Transactional
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);

	}

	@Transactional
	public void deleteCustomer(int id) {
		customerDao.deleteCustomer(id);
	}
}
