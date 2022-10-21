package com.scalereal.solid.srp.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.scalereal.model.BillGenerate;
import com.scalereal.model.Cart;
import com.scalereal.model.Product;
import com.scalereal.model.user.User;
import com.scalereal.solid.ocp.user.CartService;
import com.scalereal.util.JPAUtil;

public class CartServiceImpl implements CartService  {

	  
	  public List<Product> viewCart(int user_id) {
	       
		  EntityManager em=JPAUtil.createEntityManager("PU");
		 	Query q1 = em.createQuery("select products from Cart as c  where c.user_id IN : user_id");
			
			//TypedQuery<Doctor> query=em.createNamedQuery("findById", Doctor.class);
	 		q1.setParameter("user_id", user_id);
	 
	 	List<Product> products = q1.getResultList();
		  JPAUtil.shutDown();

		  return products;  
		  
		  
		  
		    }

	  
	
	  

		public void addProductToCart(long product_id,Cart cart,long user_id) 
		{
			

			  
			  EntityManager em=JPAUtil.createEntityManager("PU");
				Query q = em.createQuery("select p from Product as p  where p.product_id IN : product_id");
				Query q1 = em.createQuery("select u from User as u  where u.user_id IN : user_id");
				
				//TypedQuery<Doctor> query=em.createNamedQuery("findById", Doctor.class);
				q.setParameter("product_id", product_id);
				q1.setParameter("user_id", user_id);
			 		
				Product product=(Product)q.getSingleResult();
				User user=(User)q.getSingleResult();
				
		 cart.setProduct(product);
		 cart.setUser(user);
		 
		 Query q2= em.createNativeQuery("INSERT INTO cart ( product, user) VALUES (?,?)");
	     q2.setParameter(0,cart.getProduct());
	     q2.setParameter(0,cart.getUser());
	       
	     q2.executeUpdate();
		 
	     
		  JPAUtil.shutDown();

		 
	    
		}

	  
	  
	  

		public void removeProductFromCart(long product_id,long cart_id) 
		{
			
			 
			  EntityManager em=JPAUtil.createEntityManager("PU");
		try {	 
			  Query q = em.createQuery(" DELETE FROM Cart c WHERE (\\\"select p from Product as p  where p.product_id IN : p.product_id\\\") IN :(\"select c from Cart as c  where c.cart_id IN : cart_id\") ");
					
			  
			 
			  
				 q.setParameter("cart_id", cart_id);
				q.setParameter("product_id", product_id);
			 		
			 q.executeUpdate();
			 JPAUtil.shutDown();

		}
		catch(Exception e) {}	  
	  	 
	    	
			
		}

		
		 

		public BillGenerate buyProductFromCart(long  cart_id) 
		{
			EntityManager em = JPAUtil.createEntityManager("PU");
			  
			Query q = em.createQuery("select Product from Cart c where c.cart_id IN : cart_id");
			q.setParameter("cart_id", cart_id);
			 
			
			List<Product> products = q.getResultList();
			double actualAmount =0;
			
			for(Product pd1 : products) {
				
		 		
				actualAmount=actualAmount + pd1.getProduct_price();
			
			 
			}
			
			BillGenerate bill=generateBill(actualAmount);
			
			return bill;
			
		}
		
		
			  
			  
		public BillGenerate generateBill(double actualAmount) 
		{
			
			
			EntityManager em = JPAUtil.createEntityManager("PU");
		 
			BillGenerate bill = new BillGenerate();
			
			double finalAmount=0;
			
		if(actualAmount > 10000)
		{
			double discount =500;
			
		finalAmount = actualAmount - discount;
			
		
		 
		 Query q2= em.createNativeQuery("INSERT INTO billGenerate ( actualAmount, discount,finalAmount) VALUES (?,?,?)");
	     q2.setParameter(0,bill.getCart());
	     q2.setParameter(0,bill.getActualAmount());
	     q2.setParameter(0,bill.getFinalAmount());
	     
	     q2.executeUpdate();
		
		long bid=bill.getBill_id();
	     Query q = em.createQuery("select b from billGenerate b where b.bid IN : bid");
	     
			q.setParameter("bid", bid);
			 
			
			BillGenerate billGenerate =(BillGenerate) q.getSingleResult();
		
	     return billGenerate;
	     
			
		}
		
		else if(actualAmount < 10000) 
		{
			
		
			double discount =0;
			
			finalAmount = actualAmount;
				
			
			 
			 Query q2= em.createNativeQuery("INSERT INTO billGenerate ( actualAmount, discount,finalAmount) VALUES (?,?,?)");
		     q2.setParameter(0,bill.getCart());
		     q2.setParameter(0,bill.getActualAmount());
		     q2.setParameter(0,bill.getFinalAmount());
		     
		     q2.executeUpdate();
			
			long bid=bill.getBill_id();
		     Query q = em.createQuery("select b from billGenerate b where b.bid IN : bid");
		     
				q.setParameter("bid", bid);
				 
				
				BillGenerate billGenerate =(BillGenerate) q.getSingleResult();
			
		     return billGenerate;
		     
				
		
		}
		
		
		return bill;	
		
		
		}
			  
	 
	
}
