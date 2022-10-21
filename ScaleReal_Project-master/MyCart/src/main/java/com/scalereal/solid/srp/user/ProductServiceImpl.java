package com.scalereal.solid.srp.user;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.scalereal.model.Product;
import com.scalereal.solid.ocp.user.ProductService;
import com.scalereal.util.JPAUtil;

public class ProductServiceImpl implements ProductService  {


	public Product getProductById(long product_id) {

		EntityManager em = JPAUtil.createEntityManager("PU");
		Query q = em.createQuery("select p from Product as p  where p.product_id IN :product_id");

		q.setParameter("product_id", product_id);
		Product product = (Product) q.getSingleResult();

		return product;

	}

}
