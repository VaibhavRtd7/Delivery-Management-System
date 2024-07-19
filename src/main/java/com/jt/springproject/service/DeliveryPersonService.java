package com.jt.springproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.springproject.entity.Customer;
import com.jt.springproject.entity.DeliveryPerson;
import com.jt.springproject.repository.DeliveryPersonDao;

@Service
public class DeliveryPersonService {
	@Autowired
	private DeliveryPersonDao deliveryPersonDao;
	
	public DeliveryPerson getCredentail(String email,String password) 
	{
		DeliveryPerson dp = deliveryPersonDao.authenticate(email, password);
		return dp;
	}
	
	public void addDeliveryPerson(final DeliveryPerson deliveryPerson) {
		deliveryPersonDao.addDeliveryPerson(deliveryPerson);
	}
	
	public boolean emailExist(final String email) {
		if(deliveryPersonDao.emailExist(email)) {
			return true;
		}
		return false;
	}
	
	public boolean contactExist(final Long contact_no) {
		if(deliveryPersonDao.contactExist(contact_no)) {
			return true;
		}
		return false;
	}
}
