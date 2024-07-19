package com.jt.springproject.controller;

import java.sql.Clob;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.sql.rowset.serial.SerialClob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.jt.springproject.entity.Category;
import com.jt.springproject.entity.Customer;
import com.jt.springproject.entity.DeliveryPerson;
import com.jt.springproject.entity.Order;
import com.jt.springproject.service.CategoryService;
import com.jt.springproject.service.CustomerService;
import com.jt.springproject.service.OrderService;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/customer")
public class CustomerController 
{
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private OrderService orderService;
	
	
	
	@RequestMapping("/login")
	public String loginPage() 
	{
		return "login";
	}
	
	@PostMapping("/customerLogin")
	public String customerlogin(@RequestParam("email") String email, @RequestParam("password") String password,HttpSession session,Model model) 
	{
		Customer customer = customerService.getCredentail(email, password);
	    if (customer != null) {
	        // If the customer exists, set the session attribute to store the customer object
	        session.setAttribute("customer", customer);
	        return "redirect:/";
	    } else {
	        // If the customer does not exist, show an error message
	        model.addAttribute("errorMessage", "Invalid email or password.");
	        return "login";
	    }
	}
	
	@RequestMapping("/register")
	public String registerPage() 
	{
		return "register";
	}
	
	@RequestMapping("/addCustomer")
	public String registerPage(@RequestParam(value = "username", required = true) String name,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "password", required = true) String pass,
			@RequestParam(value = "contact_no", required = true) Long contact_no,Model model) 
	{
		if(customerService.emailExist(email)) {
			model.addAttribute("errorMessage", "Email already exist.");
	        return "register";
		}
		if(customerService.contactExist(contact_no)) {
			model.addAttribute("errorMessage", "Contact Number already exist.");
	        return "register";
		}
		Customer customer = new Customer();
		customer.setUsername(name);
		customer.setEmail(email);
		customer.setPassword(pass);
		customer.setContact_no(contact_no);
		customerService.addCustomer(customer);
		return "redirect:/";
	}
	
	@RequestMapping("/orders")
	public String orderPage(Model model) 
	{
		List<Category> categories = categoryService.getAllCategories();
		model.addAttribute("categories", categories);
		return "orders";
	}
	
	@RequestMapping("/addOrder")
	public String addOrder(@RequestParam(value = "pickup_add", required = true) String pickup,
			@RequestParam(value = "dest_add", required = true) String destination,
			@RequestParam(value = "category", required = true) int categoryId,HttpSession session) throws SQLException
	{
		Customer customer = (Customer) session.getAttribute("customer");
		int randomNumber = new Random().nextInt(90000) + 10000;
		String refCode = Integer.toString(randomNumber);
		Category category = categoryService.getCategoryById(categoryId);
		Order order = new Order();
		order.setRef_code(refCode);
		order.setPickup_address(new SerialClob(pickup.toCharArray()));
		order.setDestination_address(new SerialClob(destination.toCharArray()));
		order.setCustomer(customer);
		order.setCategory(category);
		order.setCost(50.00);
		customerService.addOrder(order);
		return "redirect:/";
	}
	
	@RequestMapping("/history")
	public String historyPage(Model model,HttpSession session) 
	{
		Customer customer = (Customer) session.getAttribute("customer");
		List<Order> orders = orderService.getCustomerOrder(customer);
		model.addAttribute("orders", orders);
		return "order_list";
	}
	
	@GetMapping("update/order/{id}")
	public String updatePage(@PathVariable("id") int id, Model model) {
		Order order = orderService.getOrder(id);
		List<Category> categories = categoryService.getAllCategories();
		model.addAttribute("categories", categories);
		model.addAttribute("order", order);
		return "update_order";
	}
	
	@PostMapping("update/order")
	public String updateOrder(@RequestParam("order_id") int id, @RequestParam(value = "pickup_add", required = true) String pickup,
			@RequestParam(value = "dest_add", required = true) String destination,
			@RequestParam(value = "category", required = true) int categoryId,HttpSession session) throws SerialException, SQLException {
		Category category = categoryService.getCategoryById(categoryId);
		 Order order = orderService.getOrder(id);
		order.setPickup_address(new SerialClob(pickup.toCharArray()));
		order.setDestination_address(new SerialClob(destination.toCharArray()));
		order.setCategory(category);
		customerService.updateOrder(order);
		return "redirect:/customer/history";
	}
	
	@GetMapping("delete/order/{id}")
	public String deleteOrder(@PathVariable("id") int id, Model model) {
		customerService.deleteOrder(id);
		return "redirect:/customer/history";
	}
	
	@GetMapping("view/deliveryPerson/{id}")
	public String viewDeliveryPerson(@PathVariable("id") int id, Model model, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customer");
	    DeliveryPerson dp = orderService.getDeliveryPerson(id); // Retrieve the customer from the order
	    Order orders = orderService.getOrder(id); // Retrieve orders for the customer
	    model.addAttribute("deliveryPerson", dp); // Add the customer to the model
	    model.addAttribute("orders", orders); // Add the orders to the model
	    return "order_info"; // Redirect to the desired page
	}
}
