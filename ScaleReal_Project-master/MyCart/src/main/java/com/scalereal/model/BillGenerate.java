package com.scalereal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BillGenerate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bill_id;
	private double actualAmount;
	private double discount;
	private double finalAmount;
	
	
	@OneToOne
	private Cart cart;

	 
	
	public BillGenerate() {
		super();
	}

 


	public BillGenerate(long bill_id, double actualAmount, double discount, double finalAmount, Cart cart) {
		super();
		this.bill_id = bill_id;
		this.actualAmount = actualAmount;
		this.discount = discount;
		this.finalAmount = finalAmount;
		this.cart = cart;
	}




	public long getBill_id() {
		return bill_id;
	}




	public void setBill_id(long bill_id) {
		this.bill_id = bill_id;
	}




	public double getActualAmount() {
		return actualAmount;
	}




	public void setActualAmount(double actualAmount) {
		this.actualAmount = actualAmount;
	}




	public double getDiscount() {
		return discount;
	}




	public void setDiscount(double discount) {
		this.discount = discount;
	}




	public double getFinalAmount() {
		return finalAmount;
	}




	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}




	public Cart getCart() {
		return cart;
	}




	public void setCart(Cart cart) {
		this.cart = cart;
	}




	@Override
	public String toString() {
		return "BillGenerate [bill_id=" + bill_id + ", actualAmount=" + actualAmount + ", discount=" + discount
				+ ", finalAmount=" + finalAmount + ", cart=" + cart + "]";
	}
	
	
	 
	
	
}
