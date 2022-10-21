package com.scalereal.client;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;

import com.scalereal.model.Cart;
import com.scalereal.model.user.SignIn;
import com.scalereal.model.user.User;
import com.scalereal.solid.srp.user.CartServiceImpl;
import com.scalereal.solid.srp.user.CategoryServiceImpl;
import com.scalereal.solid.srp.user.ProductServiceImpl;
import com.scalereal.solid.srp.user.UserService;
 
 
import com.scalereal.util.JPAUtil;


 

public class UserActivity {

	 public static void main(String[] args) {
		
		// performUserSingUp();
		// performUserSingIn();
		 //accessCategory();
		 
		 accessCart();
	} 
	 
	 
	 public static void performUserSingUp() 
	 {
		 
		 
		 

		 
		 Scanner scanner=new Scanner(System.in);
			
			System.out.print("Enter First_name : ");
		String	First_name=scanner.next();
			
		
		System.out.print("Enter Last_name : ");
		String	Last_name=scanner.next();
			
		
		System.out.print("Enter email : ");
		String	email=scanner.next();
			
		System.out.print("Enter password : ");
		String	password=scanner.next();
			
		
		System.out.print("Enter mobileNumber : ");
		String	mobileNumber=scanner.next();
			
		System.out.print("Enter date of registration  DOJ format 'dd-MMM-yyyy' : ");
		String temp=scanner.next();
	LocalDate doj=LocalDate.parse(temp, DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
			
	 		 
		 User u=new User(First_name,Last_name,email,password,mobileNumber,doj);
	 		
		 UserService service=new UserService();
		 
		 service.signUp(u);

		 
	 }
	 
	 
	 
	 public static void performUserSingIn() 
	 {
		 
		 
		 

		 
		 Scanner scanner=new Scanner(System.in);
		 	
		
		System.out.print("Enter email : ");
		String	email=scanner.next();
			
		System.out.print("Enter password : ");
		String	password=scanner.next();
			
		SignIn u=new SignIn( email,password );
	 		
		 UserService service=new UserService();
		 
		 service.signIn(u);

		 
	 }
	 
	 
	 public static void accessCategory() 
	 {
		 
		 CategoryServiceImpl categoryimpl=new CategoryServiceImpl();
		 categoryimpl.viewCategories();
		 categoryimpl.getProductsByCategoryId(101);
		
	
		 
	 }
	 
	 
	 public static void accessCart() 
	 {
		 
	 
		 
		 CartServiceImpl cart=new CartServiceImpl(); 
		 
		 Cart selectCart=new Cart();
		 cart.addProductToCart(1,selectCart , 101);
		 
		 cart.removeProductFromCart(2,selectCart.getCart_id());
		 
		 
		 System.out.println(cart.buyProductFromCart(selectCart.getCart_id()));
	
		 
	 }
	 
	  
	 
}
