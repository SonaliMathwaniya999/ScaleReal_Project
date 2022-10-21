package com.scalereal.model;

import javax.persistence.OneToOne;

import com.scalereal.model.user.User;

public class CheckoutItemDto {

    private int  quantity;
      
    @OneToOne
    private Product product;
    
    @OneToOne
    private User userId;

    public CheckoutItemDto() {}

	public CheckoutItemDto(int quantity, Product product, User userId) {
		super();
		this.quantity = quantity;
		this.product = product;
		this.userId = userId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "CheckoutItemDto [quantity=" + quantity + ", product=" + product + ", userId=" + userId + "]";
	}
 
    
}
