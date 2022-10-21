package com.scalereal.client;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.scalereal.model.BillGenerate;
import com.scalereal.model.Cart;
import com.scalereal.model.Category;
import com.scalereal.model.Product;
import com.scalereal.model.admin.Admin;
import com.scalereal.model.admin.AdminSignIn;
import com.scalereal.model.user.SignIn;
import com.scalereal.model.user.User;
import com.scalereal.solid.srp.admin.AdminCategoryServiceImpl;
import com.scalereal.solid.srp.admin.AdminGetBillsServiceImpl;
import com.scalereal.solid.srp.admin.AdminProductServiceImpl;
import com.scalereal.solid.srp.admin.AdminService;
import com.scalereal.solid.srp.user.CartServiceImpl;
import com.scalereal.solid.srp.user.CategoryServiceImpl;
import com.scalereal.solid.srp.user.UserService;

public class AdminActivity {

	 public static void main(String[] args) {
			
			// performAdminSingUp();
			// performAdminSingIn();
			 //productAdminService();
			 
		// categoryAdminService();
		 
		 
		 accessBillService();
		} 
		 
		 
		 public static void performAdminSingUp() 
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
				
			
			 			
		 		 
			 Admin u=new Admin(First_name,Last_name,email,password );
		 		
			 AdminService service=new AdminService();
			 
			 service.signUp(u);

			 
		 }
		 
		 
		 
		 public static void performAdminSingIn() 
		 {
			 
			 
			 

			 
			 Scanner scanner=new Scanner(System.in);
			 	
			
			System.out.print("Enter email : ");
			String	email=scanner.next();
				
			System.out.print("Enter password : ");
			String	password=scanner.next();
				
			AdminSignIn u=new AdminSignIn( email,password );
		 		
			AdminService service=new AdminService();
			 
			 service.signIn(u);

			 
		 }
		 
		 
		 public static void productAdminService() 
		 {
			 AdminProductServiceImpl productImpl=new AdminProductServiceImpl();
			
			 
			 Scanner scanner=new Scanner(System.in);
				System.out.print("Enter product Details : \n----------------------");
					
			
			System.out.print("Enter product_name : ");
			String	product_name=scanner.next();
				
			System.out.print("Enter product_price : ");
			double	product_price=scanner.nextDouble();
			
			System.out.print("Enter product_rating : ");
			double	product_rating=scanner.nextDouble();
			
		 
			System.out.print("Enter date of registration  DOJ format 'dd-MMM-yyyy' : ");
			String temp=scanner.next();
		LocalDate doj=LocalDate.parse(temp, DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
		
			Product p=new Product(product_name,product_price,product_rating,doj);
		 	 productImpl.addProduct(p);
			 
		 	  productImpl.viewProductsByCarts();
		
			 
		 }
		 
		 
		 
		 public static void categoryAdminService() 
		 {
			 AdminCategoryServiceImpl productImpl=new AdminCategoryServiceImpl();
			List<Product> products=new ArrayList();
			 
			 Scanner scanner=new Scanner(System.in);
			 System.out.print("Enter Category Details : \n----------------------");
				 	
			
			System.out.print("Enter category_name : ");
			String	category_name=scanner.next();
			System.out.print("Enter How many product you want to enter : ");
			
			int t=scanner.nextInt();
			
			for(int i=0;i<t;i++)
			{
			
			System.out.print("Enter product_name : ");
			String	product_name=scanner.next();
			
			
			System.out.print("Enter product_price : ");
			double	product_price=scanner.nextDouble();
			
			System.out.print("Enter product_rating : ");
			double	product_rating=scanner.nextDouble();
			
		 
			System.out.print("Enter date of registration  DOJ format 'dd-MMM-yyyy' : ");
			String temp=scanner.next();
		LocalDate doj=LocalDate.parse(temp, DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
		
		products.add(new Product(product_name,product_price,product_rating,doj));
		
			}
			
			
			//Product p=new Product(product_name,product_price,product_rating,doj);
		 	
			Category category=new Category(category_name,products);
			
			productImpl.addCategory(category);
			 
		 	  
			 
		 }
		 
		 
		 
		 public static void accessBillService()
		 {
			 AdminGetBillsServiceImpl getBills=new AdminGetBillsServiceImpl();
			 
			 
			 List<BillGenerate> bills = getBills.getBills();
		 
			 for(BillGenerate bill : bills)
			 {
				 System.out.println(bill);
			 }	
			 
		 }
		 
		  
		 
}
