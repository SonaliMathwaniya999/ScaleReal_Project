package com.scalereal.solid.srp.admin;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.scalereal.exception.AuthenticationFailException;
import com.scalereal.exception.CustomException;
import com.scalereal.model.admin.Admin;
import com.scalereal.model.admin.AdminSignIn;
import com.scalereal.model.user.SignIn;
import com.scalereal.model.user.User;
import com.scalereal.util.Helper;
import com.scalereal.util.JPAUtil;

public class AdminService {


	 
    public void signUp(Admin admin)  throws CustomException {
        // Check to see if the current email address has already been registered.
    	  
		  EntityManager em=JPAUtil.createEntityManager("PU");
		  String Email=admin.getEmail();
		 	Query q1 = em.createQuery("select a from admin as a  where a.email = : Email");
			 
		 	q1.setParameter("Email", Email);
	
	 		 Admin admin1 =(Admin) q1.getSingleResult();
	 		
    	
    	
    	if (Helper.notNull(admin1)) {
            // If the email address has been registered then throw an exception.
            throw new CustomException("Admin already exists");
        }
    	else
    	{
    		
    		 Query q2= em.createNativeQuery("INSERT INTO User (First_name, Last_name, email, password) VALUES (?,?,?,?)");
    	     q2.setParameter(0, admin.getFirst_name());
    	     q2.setParameter(0,admin.getLast_name());
    	      
    	     q2.setParameter(0, admin.getEmail());
    	     q2.setParameter(0,admin.getPassword());
    	       
    	     
    	     
    	     q2.executeUpdate();
    			
    		System.out.println("Admin Registration successful");
    		
    		
    	}

      
  
    }

    public void signIn(AdminSignIn adminSignIn) throws AuthenticationFailException {
         
    	
    	EntityManager em=JPAUtil.createEntityManager("PU");
		  String Email=adminSignIn.getEmail();
		  String password=adminSignIn.getPassword();
		 	Query q1 = em.createQuery("select a from admin as a  where a.email = :Email AND a.password = :password ");
			
			//TypedQuery<Doctor> query=em.createNamedQuery("findById", Doctor.class);
	 		q1.setParameter("Email", Email);
	 		q1.setParameter("password", password);
	 		
	 		 Admin admin1 =(Admin) q1.getSingleResult();
      
        if(!Helper.notNull(admin1)){
            throw  new AuthenticationFailException("admin not present");
        }
        else 
        {
        	System.out.println("Admin login successfully");
        }     
	
	
	
    }
	
	 
    

	
	
	
	
}
