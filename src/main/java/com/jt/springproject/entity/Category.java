package com.jt.springproject.entity;

import java.io.Serializable;
import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name="product_category")
public class Category implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private String product_type;
	
	@Column
	private String description;
	
	@OneToMany(mappedBy="category",cascade = CascadeType.ALL)
    List<Order> orders;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int id, String product_type, String description) {
		super();
		this.id = id;
		this.product_type = product_type;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
	
}
