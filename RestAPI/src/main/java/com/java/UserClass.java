package com.java;

public class UserClass {

	int id;
	String username;
	String firstname;
	String laststname;
	String email;
	String mobile;
	String address;
	int NoOforders;
	public UserClass() {}
	public UserClass(int i,String username, String firstname, String laststname, String email, String mobile, String address,
			int noOforders) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.laststname = laststname;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.id = i;
		this.NoOforders = noOforders;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLaststname() {
		return laststname;
	}

	public void setLaststname(String laststname) {
		this.laststname = laststname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNoOforders() {
		return NoOforders;
	}

	public void setNoOforders(int noOforders) {
		NoOforders = noOforders;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
		
}
