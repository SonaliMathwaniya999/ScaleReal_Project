package com.scalereal.solid.srp.admin;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.scalereal.model.Category;
import com.scalereal.solid.ocp.admin.AdminCategoryService;
import com.scalereal.util.JPAUtil;

public class AdminCategoryServiceImpl implements AdminCategoryService{

	
	public void addCategory(Category category) 
	  {   
		  EntityManager em=JPAUtil.createEntityManager("PU");
			 
			 Query q2= em.createNativeQuery("INSERT INTO Category ( category_name, products) VALUES (?,?)");
		   	 
			 q2.setParameter(0,category.getCategory_name());
		     q2.setParameter(0,category.getProducts());
		       
		     q2.executeUpdate();
		  

			  JPAUtil.shutDown();

		  
	  }
}
