package com.scalereal.solid.srp.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.scalereal.exception.AuthenticationFailException;
import com.scalereal.exception.CustomException;
import com.scalereal.model.Product;
import com.scalereal.model.user.SignIn;
import com.scalereal.model.user.User;
import com.scalereal.util.Helper;
import com.scalereal.util.JPAUtil;

public class UserService {

	
 
    public void signUp(User user)  throws CustomException {
        // Check to see if the current email address has already been registered.
    	  
		  EntityManager em=JPAUtil.createEntityManager("PU");
		  String Email=user.getEmail();
		 	Query q1 = em.createQuery("select u from User as u  where u.email = : Email");
			
			//TypedQuery<Doctor> query=em.createNamedQuery("findById", Doctor.class);
	 		q1.setParameter("Email", Email);
	
	 		 User user1 =(User) q1.getSingleResult();
	 		
    	
    	
    	if (Helper.notNull(user1)) {
            // If the email address has been registered then throw an exception.
            throw new CustomException("User already exists");
        }
    	else
    	{
   	
    		 Query q2= em.createNativeQuery("INSERT INTO User (First_name,Last_name,email,password,mobileNumber, dateofreg) VALUES (?,?,?,?,?,?)");
    	     q2.setParameter(0, user.getFirst_name());
    	     q2.setParameter(0,user.getLast_name());
    	      
    	     q2.setParameter(0, user.getEmail());
    	     q2.setParameter(0,user.getPassword());
    	     q2.setParameter(0, user.getMobileNumber());
    	     q2.setParameter(0,user.getDateofreg());
    	      
    	     
    	     
    	     q2.executeUpdate();
    			
    		System.out.println("User created");
    		
    		
    	}

      
  
    }

    public void signIn(SignIn signIn) throws AuthenticationFailException {
        // first find User by email
    	 EntityManager em=JPAUtil.createEntityManager("PU");
		  String Email=signIn.getEmail();
		  String password=signIn.getPassword();
		 	Query q1 = em.createQuery("select u from User as u  where u.email = :Email AND u.password = :password ");
			
			//TypedQuery<Doctor> query=em.createNamedQuery("findById", Doctor.class);
	 		q1.setParameter("Email", Email);
	 		q1.setParameter("password", password);
	 		
	 		 User user1 =(User) q1.getSingleResult();
      
        if(!Helper.notNull(user1)){
            throw  new AuthenticationFailException("user not present");
        }
        else 
        {
        	System.out.println("User login successfully");
        }     
	
	
	
    }
	
	 
    
    
    
}
