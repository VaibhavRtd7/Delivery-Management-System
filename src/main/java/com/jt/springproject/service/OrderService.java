package com.jt.springproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.springproject.entity.Customer;
import com.jt.springproject.entity.DeliveryPerson;
import com.jt.springproject.entity.Order;
import com.jt.springproject.repository.OrderDao;

@Service
public class OrderService {
	@Autowired
	private OrderDao orderDao;
	
	public Order getOrder(final int id) {
		return orderDao.getOrder(id);
	}
	public Customer getCustomer(final int id) {
		Order order = getOrder(id); // Retrieve the order by ID
		if (order != null) {
			return order.getCustomer(); // Retrieve the customer from the order
		}
		return null; // Return null if order is not found
	}
	
	public DeliveryPerson getDeliveryPerson(final int id) {
		Order order = getOrder(id); // Retrieve the order by ID
		if (order != null) {
			return order.getDeliveryPerson(); // Retrieve the delivery person from the order
		}
		return null; // Return null if order is not found
	}

	public List<Order> getCustomerOrder(final Customer customer){
		return orderDao.getCustomerOrder(customer);
	}
	public List<Order> getDeliveryPersonOrder(final DeliveryPerson dp){
		return orderDao.getDeliveryPersonOrder(dp);
	}
	public List<Order> getUndeliverOrder(){
		return orderDao.getUndeliverOrder();
	}
}
