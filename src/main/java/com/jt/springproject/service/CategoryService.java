package com.jt.springproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.springproject.repository.CategoryDao;

import jakarta.persistence.EntityManager;
import com.jt.springproject.entity.Category;
import com.jt.springproject.entity.Customer;
@Service
public class CategoryService {
		@Autowired
		private CategoryDao categoryDao;
		
		public List<Category> getAllCategories(){
			return categoryDao.getAllCategories();
		}
		
		public Category getCategoryById(final int id) {
			return categoryDao.getCategoryById(id);
		}
		
		public void addCategory(final Category category) {
			categoryDao.addCategory(category);
		}
}
