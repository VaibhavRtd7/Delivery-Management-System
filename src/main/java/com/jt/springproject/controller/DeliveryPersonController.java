package com.jt.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jt.springproject.entity.Category;
import com.jt.springproject.entity.Customer;
import com.jt.springproject.entity.DeliveryPerson;
import com.jt.springproject.entity.Order;
import com.jt.springproject.service.CategoryService;
import com.jt.springproject.service.CustomerService;
import com.jt.springproject.service.DeliveryPersonService;
import com.jt.springproject.service.OrderService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/deliveryPerson")
public class DeliveryPersonController {
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private DeliveryPersonService deliveryPersonService;
	
	@RequestMapping("/login")
	public String loginPage() 
	{
		return "dplogin";
	}
	
	@PostMapping("/dpLogin")
	public String dplogin(@RequestParam("email") String email, @RequestParam("password") String password,HttpSession session,Model model) 
	{
		DeliveryPerson dp = deliveryPersonService.getCredentail(email, password);
	    if (dp != null) {
	        // If the customer exists, set the session attribute to store the customer object
	        session.setAttribute("dp", dp);
	        return "redirect:/";
	    } else {
	        // If the customer does not exist, show an error message
	        model.addAttribute("errorMessage", "Invalid email or password.");
	        return "dplogin";
	    }
	}
	
	@RequestMapping("/register")
	public String registerPage() 
	{
		return "dpregister";
	}
	
	@RequestMapping("/addDeliveryPerson")
	public String registerPage(@RequestParam(value = "username", required = true) String name,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "password", required = true) String pass,
			@RequestParam(value = "contact_no", required = true) Long contact_no,Model model) 
	{
		if(deliveryPersonService.emailExist(email)) {
			model.addAttribute("errorMessage", "Email already exist.");
	        return "register";
		}
		if(deliveryPersonService.contactExist(contact_no)) {
			model.addAttribute("errorMessage", "Contact Number already exist.");
	        return "register";
		}
		DeliveryPerson dp = new DeliveryPerson();
		dp.setUsername(name);
		dp.setEmail(email);
		dp.setPassword(pass);
		dp.setContact_no(contact_no);
		deliveryPersonService.addDeliveryPerson(dp);
		return "redirect:/";
	}
	
	@RequestMapping("/orders")
	public String orderPage(Model model,HttpSession session) 
	{
		List<Order> orders = orderService.getUndeliverOrder();
		model.addAttribute("orders", orders);
		return "order_history";
	}
	
	@GetMapping("accept/order/{id}")
	public String acceptOrder(@PathVariable("id") int id, Model model,HttpSession session) {
		DeliveryPerson dp = (DeliveryPerson) session.getAttribute("dp");
		Order order = orderService.getOrder(id);
		order.setDeliveryPerson(dp);
		customerService.updateOrder(order);
		return "redirect:/deliveryPerson/history";
	}
	
	@GetMapping("view/customer/{id}")
	public String viewCustomer(@PathVariable("id") int id, Model model, HttpSession session) {
	    DeliveryPerson dp = (DeliveryPerson) session.getAttribute("dp");
	    Customer customer = orderService.getCustomer(id); // Retrieve the customer from the order
	    Order orders = orderService.getOrder(id); // Retrieve orders for the customer
	    model.addAttribute("customer", customer); // Add the customer to the model
	    model.addAttribute("orders", orders); // Add the orders to the model
	    return "order_summary"; // Redirect to the desired page
	}

	
	@RequestMapping("/history")
	public String historyPage(Model model,HttpSession session) 
	{
		DeliveryPerson dp = (DeliveryPerson) session.getAttribute("dp");
		List<Order> orders = orderService.getDeliveryPersonOrder(dp);
		model.addAttribute("orders", orders);
		return "dp_order_history";
	}
}
