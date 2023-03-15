package com.java;
//10.94.12.33 ridham 10.85.148.112: shreyas


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/User")
public class UserService {
	
	static List<UserClass> Userlist = new ArrayList<UserClass>();
	static {
		
		Userlist.add(new UserClass(1,"User1","jack","josef","user@gmail.com","1234567890","adarsh nagar,pune",8));
		Userlist.add(new UserClass(2,"User2","jenni","josef","jenni@gmail.com","9876543210","waked,pune",4));
		Userlist.add(new UserClass(3,"User3","smith","roy","smith@gmail.com","1234567890","hinjwadi",3));
		Userlist.add(new UserClass(4,"User4","shiva","sharma","shiva@gmail.com","1234567890","raamnagaer,hubbli",6));
		Userlist.add(new UserClass(5,"User5","sham","josef","sham@gmail.com","1234567890","shaniwar wada,pune",2));
		
	}
	public UserService() {
		System.out.println("from constructor");
	}
	
	
	@GET
	@Path("/view")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserClass> returnAllUser() {
		return Userlist;
	}
	
	
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public String add(UserClass temp) {
		for(UserClass i :Userlist) {
			if(i.getId()==temp.getId()) {
				return "<h1>user is  exist</h2>";
			}
		}
		Userlist.add(temp);
		return "the user added ";
	}
	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public String update(UserClass temp) {
		for(UserClass i :Userlist) {
			if(i.getId()==temp.getId()) {
				Userlist.remove(i);
				Userlist.add(temp);
				return "<h1>User detailes updated</h2>";
			}
		}
		return "User not found";
	}
	
	
	@DELETE
	@Path("/delete/{uid}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteIt(@PathParam("uid") int x) {
		
		for(UserClass i : Userlist) {
			if(i.getId()==x) {
				Userlist.remove(i);
				return "<h1>User is deleted</h1>";
			}
		}
		
		return "<h1>user is  not found to delete</h1>";
	}
	
	
	@GET
	@Path("/singleUser/{uid}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserClass convertIt(@PathParam("uid") int x) {
		UserClass use = null;
		for(UserClass i : Userlist) {
			if(i.getId()==x) {
				return i;
			}
		}
		
		return use;
	}
}
