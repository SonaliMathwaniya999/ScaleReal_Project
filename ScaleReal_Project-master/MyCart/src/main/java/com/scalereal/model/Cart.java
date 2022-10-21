package com.scalereal.model;

import java.util.List;

 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.scalereal.model.user.User;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cart_id;
	
	@OneToOne
	private Product product;
	
	@OneToOne
	private User user;

 
	
	public Cart() {
		super();
	}


 	public Cart(long cart_id, Product product, User user) {
		super();
		this.cart_id = cart_id;
		this.product = product;
		this.user = user;
	}


	public long getCart_id() {
		return cart_id;
	}


	public void setCart_id(long cart_id) {
		this.cart_id = cart_id;
	}


	 


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	 
	
	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	 
	
	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", product=" + product + ", user=" + user + "]";
	}
	
	 
	
}
