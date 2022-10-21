package com.scalereal.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;


@Entity
public class Product {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long product_id;
	private String product_name;
	private double product_price;
	private double product_rating;
	private LocalDate deliveryDays;
	
	
	 

	@ManyToOne
   private Category category;
	
	public Product() {
		super();
	}
 

	public Product(  String product_name, double product_price, double product_rating,
			LocalDate deliveryDays ) {
		super();
	 
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_rating = product_rating;
		this.deliveryDays = deliveryDays;
		 
	}


	public long getProduct_id() {
		return product_id;
	}


	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}


	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public double getProduct_price() {
		return product_price;
	}


	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}


	public double getProduct_rating() {
		return product_rating;
	}


	public void setProduct_rating(double product_rating) {
		this.product_rating = product_rating;
	}


	public LocalDate getDeliveryDays() {
		return deliveryDays;
	}


	public void setDeliveryDays(LocalDate deliveryDays) {
		this.deliveryDays = deliveryDays;
	}

 
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", product_price="
				+ product_price + ", product_rating=" + product_rating + ", deliveryDays=" + deliveryDays +
				"]";
	}
	
	
	
	 
	
	
}
