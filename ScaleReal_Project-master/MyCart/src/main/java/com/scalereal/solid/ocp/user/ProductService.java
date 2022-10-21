package com.scalereal.solid.ocp.user;

import com.scalereal.model.Product;

public interface ProductService  extends UserService {
	
	Product getProductById(long product_id);




}
