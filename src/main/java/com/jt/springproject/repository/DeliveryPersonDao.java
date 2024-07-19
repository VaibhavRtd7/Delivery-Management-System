package com.jt.springproject.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jt.springproject.entity.Customer;
import com.jt.springproject.entity.DeliveryPerson;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;

@Repository
public class DeliveryPersonDao {
	private EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public DeliveryPersonDao(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	@Transactional
	public boolean emailExist(final String email) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<DeliveryPerson> query = currentSession.createQuery("FROM DeliveryPerson WHERE email=:email", DeliveryPerson.class);
	    query.setParameter("email", email);
	    
	    DeliveryPerson dp = null;
	    try {
	        dp = query.getSingleResult();
	    } catch (NoResultException e) {
	        return false;
	    }
		return true;	
	}
	@Transactional
	public boolean contactExist(final Long contact_no) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<DeliveryPerson> query = currentSession.createQuery("FROM DeliveryPerson WHERE contact_no=:contact_no", DeliveryPerson.class);
	    query.setParameter("contact_no", contact_no);
	    
	    DeliveryPerson dp = null;
	    try {
	        dp = query.getSingleResult();
	    } catch (NoResultException e) {
	        return false;
	    }
		return true;	
	}
	@Transactional
	public void addDeliveryPerson(final DeliveryPerson dp) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.persist(dp);
		currentSession.close();
	}
	
	@Transactional
	public DeliveryPerson authenticate(String email, String password) {
	    // get the current hibernate session
	    Session currentSession = entityManager.unwrap(Session.class);

	    // create an HQL query to retrieve the customer with the specified email and password
	    Query<DeliveryPerson> query = currentSession.createQuery("FROM DeliveryPerson WHERE email=:email AND password=:password", DeliveryPerson.class);
	    query.setParameter("email", email);
	    query.setParameter("password", password);

	    // execute the query and return the result
	    DeliveryPerson dp = null;
	    try {
	        dp = query.getSingleResult();
	    } catch (NoResultException e) {
	        // if no customer is found, return null
	    }
	    return dp;
	}
}
