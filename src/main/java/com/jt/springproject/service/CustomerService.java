package com.jt.springproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.springproject.entity.Customer;
import com.jt.springproject.entity.Order;
import com.jt.springproject.repository.CustomerDao;

@Service
public class CustomerService {
	@Autowired
	private CustomerDao customerDao;
	
	public void addCustomer(final Customer customer) {
		customerDao.saveCustomer(customer);
	}
	
	public Customer getCredentail(String email,String password) {
		Customer customer = customerDao.authenticate(email, password);
		return customer;
	}
	
	public void addOrder(final Order order) {
		customerDao.addOrder(order);
	}
	
	public void updateOrder(final Order order) {
		customerDao.updateOrder(order);
	}
	
	public void deleteOrder(final int id) {
		customerDao.deleteOrder(id);
	}
	
	public boolean emailExist(final String email) {
		if(customerDao.emailExist(email)) {
			return true;
		}
		return false;
	}
	
	public boolean contactExist(final Long contact_no) {
		if(customerDao.contactExist(contact_no)) {
			return true;
		}
		return false;
	}
}
