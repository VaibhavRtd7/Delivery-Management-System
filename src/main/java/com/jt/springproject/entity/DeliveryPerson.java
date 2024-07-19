package com.jt.springproject.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="delivery_person",uniqueConstraints = {@UniqueConstraint(columnNames = {"email", "contact_no"})})
public class DeliveryPerson implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private String username;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Column
	private Long contact_no;
	
	@Lob
	private Blob image;

	@OneToMany(mappedBy="deliveryPerson",cascade = CascadeType.ALL)
	List<Order> order;
	public DeliveryPerson() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DeliveryPerson(int id, String username, String email, String password, Long contact_no, Blob image) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.contact_no = contact_no;
		this.image = image;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getContact_no() {
		return contact_no;
	}

	public void setContact_no(Long contact_no) {
		this.contact_no = contact_no;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "DeliveryPerson [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", contact_no=" + contact_no + ", image=" + image + "]";
	}
	
	
		
}
