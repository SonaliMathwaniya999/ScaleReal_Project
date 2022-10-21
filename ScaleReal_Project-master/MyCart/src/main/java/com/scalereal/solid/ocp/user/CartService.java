package com.scalereal.solid.ocp.user;

import java.util.List;

import com.scalereal.model.BillGenerate;
import com.scalereal.model.Cart;
import com.scalereal.model.Product;

public interface CartService  extends UserService {
	List<Product> viewCart(int user_id);
	
	void addProductToCart(long product_id,Cart cart,long user_id);
	
	
	void removeProductFromCart(long product_id,long cart_id);
	
	
	BillGenerate buyProductFromCart(long  cart_id);

	BillGenerate    generateBill(double actualAmount);
	
	
}
