package com.scalereal.solid.srp.admin;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.scalereal.model.Cart;
import com.scalereal.model.Product;
import com.scalereal.solid.ocp.admin.AdminProductService;
import com.scalereal.util.JPAUtil;

public class AdminProductServiceImpl implements AdminProductService {

	

	 public void addProduct(Product product) 
	 
	 {
		 EntityManager em=JPAUtil.createEntityManager("PU");
		 
		 Query q2= em.createNativeQuery("INSERT INTO Product ( product_name, product_price,product_rating,deliveryDays) VALUES (?,?,?,?)");
	   	 
		 q2.setParameter(0,product.getProduct_name());
	     q2.setParameter(0,product.getProduct_price());
	     q2.setParameter(0,product.getProduct_rating());
	     q2.setParameter(0,product.getDeliveryDays());
	    
	     q2.executeUpdate();
	  

		  JPAUtil.shutDown();

		 
		 
		 
	 }
	 
	 

	 public void viewProductsByCarts() {

			EntityManager em = JPAUtil.createEntityManager("PU");

			Query q = em.createQuery("select c from Cart c");

			List<Cart> carts = q.getResultList();

			for (Cart cart1 : carts) {

				List<Product> products = getProductDetails(cart1.getCart_id());

				System.out.println(products);

			}

			JPAUtil.shutDown();

		}
	 
	 
	 
	 
	 
	 
	 public List<Product> getProductDetails(long cart_id) {

			EntityManager em = JPAUtil.createEntityManager("PU");

			Query q = em.createQuery("select product from cart c  where c.cart_id IN : cart_id");

			List<Product> products = q.getResultList();

			return products;

		}

  	
}
