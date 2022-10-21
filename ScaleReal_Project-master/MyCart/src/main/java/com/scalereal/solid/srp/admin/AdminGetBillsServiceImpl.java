package com.scalereal.solid.srp.admin;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.scalereal.model.BillGenerate;
import com.scalereal.util.JPAUtil;

public class AdminGetBillsServiceImpl {

	public List<BillGenerate> getBills() {

		EntityManager em = JPAUtil.createEntityManager("PU");

		Query q = em.createQuery("select b from billgenerate b  ");

		List<BillGenerate> bills = q.getResultList();

		return bills;

	}
	
	
}
