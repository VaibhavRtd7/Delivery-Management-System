package com.jt.springproject.repository;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import com.jt.springproject.entity.Customer;
import com.jt.springproject.entity.Order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;

@Repository
public class CustomerDao {
		private EntityManager entityManager;
			
		// set up constructor injection
		@Autowired
		public CustomerDao(EntityManager theEntityManager) {
			entityManager = theEntityManager;
		}
		@Transactional
		public boolean emailExist(final String email) {
			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
			
			Query<Customer> query = currentSession.createQuery("FROM Customer WHERE email=:email", Customer.class);
		    query.setParameter("email", email);
		    
		    Customer customer = null;
		    try {
		        customer = query.getSingleResult();
		    } catch (NoResultException e) {
		        return false;
		    }
			return true;	
		}
		@Transactional
		public boolean contactExist(final Long contact_no) {
			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
			
			Query<Customer> query = currentSession.createQuery("FROM Customer WHERE contact_no=:contact_no", Customer.class);
		    query.setParameter("contact_no", contact_no);
		    
		    Customer customer = null;
		    try {
		        customer = query.getSingleResult();
		    } catch (NoResultException e) {
		        return false;
		    }
			return true;	
		}
		@Transactional
		public void saveCustomer(final Customer customer) {
			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.persist(customer);
			currentSession.close();
		}		
		@Transactional
		public Customer authenticate(String email, String password) {
		    // get the current hibernate session
		    Session currentSession = entityManager.unwrap(Session.class);

		    // create an HQL query to retrieve the customer with the specified email and password
		    Query<Customer> query = currentSession.createQuery("FROM Customer WHERE email=:email AND password=:password", Customer.class);
		    query.setParameter("email", email);
		    query.setParameter("password", password);

		    // execute the query and return the result
		    Customer customer = null;
		    try {
		        customer = query.getSingleResult();
		    } catch (NoResultException e) {
		        // if no customer is found, return null
		    }
		    return customer;
		}
		
		@Transactional
		public void addOrder(final Order order) {
			Session currentSession = entityManager.unwrap(Session.class);
		    currentSession.merge(order);
		}

		@Transactional
		public void updateOrder(final Order order) {
			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.merge(order);
			currentSession.close();
		}
		
		@Transactional
		public void deleteOrder(final int id) {
			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
			
			Order order = currentSession.get(Order.class, id);
			currentSession.remove(order);
			currentSession.close();
					
		}
}
