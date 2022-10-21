package com.scalereal.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long category_id;
	private String category_name;

	@OneToMany
	private List<Product> products;

	 
	
	public Category() {
		super();
	}


 

	public Category(  String category_name, List<Product> products) {
		super();
	 
		this.category_name = category_name;
		this.products = products;
	}




	public long getCategory_id() {
		return category_id;
	}




	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}




	public String getCategory_name() {
		return category_name;
	}




	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}




	public List<Product> getProducts() {
		return products;
	}




	public void setProducts(List<Product> products) {
		this.products = products;
	}




	@Override
	public String toString() {
		return "Category [category_id=" + category_id + ", category_name=" + category_name + ", products=" + products
				+ "]";
	}
	
	
	
	 
}
