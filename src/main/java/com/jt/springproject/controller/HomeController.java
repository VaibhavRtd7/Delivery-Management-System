package com.jt.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jt.springproject.entity.Category;
import com.jt.springproject.service.CategoryService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/category")
	public String categoryPage() {
		return "category";
	}
	
	@RequestMapping("/addCategory")
	public String addCategory(@RequestParam("type") String product_type, @RequestParam("desc") String description)
	{
		Category category = new Category();
		category.setProduct_type(product_type);
		category.setDescription(description);
		categoryService.addCategory(category);
		return "redirect:/";
	}
	
	@RequestMapping("/logout")
	public String addCategory(HttpSession session)
	{
		session.invalidate();
		return "redirect:/";
	}
}
