package com.jt.springproject.repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jt.springproject.entity.Category;
import com.jt.springproject.entity.Customer;
import com.jt.springproject.service.CategoryService;
import com.jt.springproject.service.CustomerService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import org.hibernate.query.Query;
@Repository
public class CategoryDao {
			@Autowired
			private EntityManager entityManager;
	
			// set up constructor injection
			@Autowired
			public CategoryDao(EntityManager theEntityManager) {
				entityManager = theEntityManager;
			}
			
			public Category getCategoryById(final int id) {
				// get the current hibernate session
				Session currentSession = entityManager.unwrap(Session.class);
				Category category = currentSession.get(Category.class, id);
				currentSession.close();
				return category;
			}

			public List<Category> getAllCategories() {
				// get the current hibernate session
				Session currentSession = entityManager.unwrap(Session.class);
						
				// create a query
				TypedQuery<Category> theQuery =
						currentSession.createQuery("from Category", Category.class);
				
				// execute query and get result list
				List<Category> categories = theQuery.getResultList();

				currentSession.close();
				return categories;
			}
			
			@Transactional
			public void addCategory(final Category category) {
				// get the current hibernate session
				Session currentSession = entityManager.unwrap(Session.class);
				currentSession.persist(category);
				currentSession.close();
			}	
}
