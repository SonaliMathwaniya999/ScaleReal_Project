package com.scalereal.model.user;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.scalereal.model.Cart;

@Entity
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private String First_name;
	private String Last_name;
	private String email;
	private String password;
	private String mobileNumber;
	private LocalDate dateofreg;
	
	@OneToOne
	private Cart cart;
	 
	
	public User() {
		super();
	}

 
	public User(long id) {
		super();
		Id = id;
	}
	
	 
	
	
	public User( String first_name, String last_name, String email, String password, String mobileNumber,
			LocalDate dateofreg) {
		super();
		 
		First_name = first_name;
		Last_name = last_name;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.dateofreg = dateofreg;
	}


	public long getId() {
		return Id;
	}


	public void setId(long id) {
		Id = id;
	}


	public String getFirst_name() {
		return First_name;
	}


	public void setFirst_name(String first_name) {
		First_name = first_name;
	}


	public String getLast_name() {
		return Last_name;
	}


	public void setLast_name(String last_name) {
		Last_name = last_name;
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


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public LocalDate getDateofreg() {
		return dateofreg;
	}


	public void setDateofreg(LocalDate dateofreg) {
		this.dateofreg = dateofreg;
	}


	
	
	
	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	@Override
	public String toString() {
		return "User [Id=" + Id + ", First_name=" + First_name + ", Last_name=" + Last_name + ", email=" + email
				+ ", password=" + password + ", mobileNumber=" + mobileNumber + ", dateofreg=" + dateofreg + "]";
	}
	
	
	 	
}
