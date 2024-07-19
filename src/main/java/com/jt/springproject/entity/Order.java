package com.jt.springproject.entity;

import java.io.Serializable;
import java.sql.Clob;

import jakarta.persistence.*;

@Entity
@Table(name="orders")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private String ref_code;
	
	@Column(name="pick_add")
	private Clob pickup_address;
	
	@Column(name="dest_add")
	private Clob destination_address;
	
	@Column
	private Double cost;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="deliveryperson_id", nullable = true)
	private DeliveryPerson deliveryPerson;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="category_id")
	private Category category;

	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int id, String ref_code, Clob pickup_address, Clob destination_address, Double cost, Customer customer,
			DeliveryPerson deliveryPerson, Category category) {
		super();
		this.id = id;
		this.ref_code = ref_code;
		this.pickup_address = pickup_address;
		this.destination_address = destination_address;
		this.cost = cost;
		this.customer = customer;
		this.deliveryPerson = deliveryPerson;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRef_code() {
		return ref_code;
	}

	public void setRef_code(String ref_code) {
		this.ref_code = ref_code;
	}

	public Clob getPickup_address() {
		return pickup_address;
	}

	public void setPickup_address(Clob pickup_address) {
		this.pickup_address = pickup_address;
	}

	public Clob getDestination_address() {
		return destination_address;
	}

	public void setDestination_address(Clob destination_address) {
		this.destination_address = destination_address;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public DeliveryPerson getDeliveryPerson() {
		return deliveryPerson;
	}

	public void setDeliveryPerson(DeliveryPerson deliveryPerson) {
		this.deliveryPerson = deliveryPerson;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
