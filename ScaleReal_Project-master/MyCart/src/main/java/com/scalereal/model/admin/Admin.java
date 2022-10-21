package com.scalereal.model.admin;

public class Admin {

	private long admin_id;
	private String First_name;
	private String Last_name;
	private String email;
	private String password;
	
	 
	
	public Admin() {
		super();
	}


	public Admin(  String first_name, String last_name, String email, String password) {
		super();
		 
		First_name = first_name;
		Last_name = last_name;
		this.email = email;
		this.password = password;
	}


	public Admin(long admin_id, String first_name, String last_name, String email, String password) {
		super();
		this.admin_id = admin_id;
		First_name = first_name;
		Last_name = last_name;
		this.email = email;
		this.password = password;
	}




	public long getAdmin_id() {
		return admin_id;
	}




	public void setAdmin_id(long admin_id) {
		this.admin_id = admin_id;
	}




	public String getFirst_name() {
		return First_name;
	}




	public void setFirst_name(String first_name) {
		First_name = first_name;
	}




	public String getLast_name() {
		return Last_name;
	}




	public void setLast_name(String last_name) {
		Last_name = last_name;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", First_name=" + First_name + ", Last_name=" + Last_name + ", email="
				+ email + ", password=" + password + "]";
	}
	
	
	
	
}
