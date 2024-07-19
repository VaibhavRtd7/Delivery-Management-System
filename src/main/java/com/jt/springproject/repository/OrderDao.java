package com.jt.springproject.repository;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jt.springproject.entity.Category;
import com.jt.springproject.entity.Customer;
import com.jt.springproject.entity.DeliveryPerson;
import com.jt.springproject.entity.Order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class OrderDao 
{
		@Autowired
		private EntityManager entityManager;
	
		// set up constructor injection
		@Autowired
		public OrderDao(EntityManager theEntityManager) {
			entityManager = theEntityManager;
		}
		
		public Order getOrder(final int id) {
			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
			Order order = currentSession.get(Order.class, id);
			currentSession.close();
			return order;
		}
		public List<Order> getCustomerOrder(final Customer customer) {
		    // get the current hibernate session
		    Session currentSession = entityManager.unwrap(Session.class);

		    // create a query
		    TypedQuery<Order> theQuery =
		            currentSession.createQuery("from Order where customer=:customer", Order.class);

		    theQuery.setParameter("customer", customer);
		    // execute query and get result list
		    List<Order> orders = theQuery.getResultList();

		    currentSession.close();
		    return orders;
		}

		public List<Order> getDeliveryPersonOrder(final DeliveryPerson dp) {
			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
					
			// create a query
			TypedQuery<Order> theQuery =
					currentSession.createQuery("from Order where deliveryPerson=:dp", Order.class);
			
			theQuery.setParameter("dp", dp);
			// execute query and get result list
			List<Order> orders = theQuery.getResultList();

			currentSession.close();
			return orders;
		}
		public List<Order> getUndeliverOrder() {
			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
			// create a query
						TypedQuery<Order> theQuery =
								currentSession.createQuery("from Order where deliveryPerson.id is null", Order.class);
						
						// execute query and get result list
						List<Order> orders = theQuery.getResultList();

						currentSession.close();
						return orders;
		}
		

}
