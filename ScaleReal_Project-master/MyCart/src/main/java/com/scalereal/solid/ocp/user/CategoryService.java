package com.scalereal.solid.ocp.user;

import java.util.List;

import com.scalereal.model.Category;
import com.scalereal.model.Product;

public interface CategoryService  extends UserService {

 public	List<Category> viewCategories();
	
	
 public	List<Product> getProductsByCategoryId(long category_id);





}
