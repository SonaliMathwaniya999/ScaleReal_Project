package com.scalereal.solid.srp.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.scalereal.model.Category;
import com.scalereal.model.Product;
import com.scalereal.solid.ocp.user.CategoryService;
import com.scalereal.util.JPAUtil;

public class CategoryServiceImpl implements CategoryService  {

	
	

	
	public List<Category> viewCategories()
	{
  	
		EntityManager em = JPAUtil.createEntityManager("PU");
		  
		Query q = em.createQuery("select c from Category as c");
		  List<Category> categories = q.getResultList();
		  
		
		  
		  
		  return categories;  
		  
		  
		 
		
	}
		 public List<Product> getProductsByCategoryId(long category_id)
			{
				   
				  
				  EntityManager em=JPAUtil.createEntityManager("PU");
					Query q = em.createQuery("select products from Category as c  where c.category_id IN :category_id");
					
					//TypedQuery<Doctor> query=em.createNamedQuery("findById", Doctor.class);
					q.setParameter("category_id", category_id);
					List<Product> products=q.getResultList();
				
				//	System.out.println("Category Name : "+category.getCategory_name());
			
					
					  return  products;
				   
				 
			} 
		
		
}

