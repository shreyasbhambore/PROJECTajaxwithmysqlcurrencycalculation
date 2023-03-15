package com.java;


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

import com.java.layer2.Currency;

@Path("/currency")
public class currencyservice {

	static List<Currency> currlist = new ArrayList<Currency>();
	static {
		Currency curr1 = new Currency();
		curr1.setCurrencyId(1);
		curr1.setSourceCurrency("USD");
		curr1.setTargetcurrency("INR");
		curr1.setLoadFactor(500);
		
		Currency curr2 = new Currency();
		curr2.setCurrencyId(2);
		curr2.setSourceCurrency("EUR");
		curr2.setTargetcurrency("INR");
		curr2.setLoadFactor(500);
		
		Currency curr3 = new Currency();
		curr3.setCurrencyId(3);
		curr3.setSourceCurrency("DIN");
		curr3.setTargetcurrency("INR");
		curr3.setLoadFactor(500);
		currlist.add(curr1);
		currlist.add(curr2);
		currlist.add(curr3);
		
	}
	
	public currencyservice() {
		System.out.println("currency constructor");
		
	}
	
	@GET
	@Path("/init")
	public String init() {
		System.out.println("currency service");
		
		return "<h1>init is done</h1>";
	}
	
	@GET
	@Path("/greet")
	public String wellcome() {
		return "<h1>Currency detailes</h1>";
	}
	
	@GET
	@Path("/convert/{cid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Currency convertIt(@PathParam("cid") int x) {
		Currency curr = null;
		for(Currency i : currlist) {
			if(i.getCurrencyId()==x) {
				return i;
			}
		}
		
		return curr;
	}
	
//	@GET
	@DELETE
	@Path("/delete/{cid}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteIt(@PathParam("cid") int x) {
		
		for(Currency i : currlist) {
			if(i.getCurrencyId()==x) {
				currlist.remove(i);
				return "<h1>item deleted</h1>";
			}
		}
		
		return "<h1>item not found</h1>";
	}
	
	
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public String add(Currency temp) {
		for(Currency i :currlist) {
			if(i.getCurrencyId()==temp.getCurrencyId()) {
				return "<h1>item exist</h2>";
			}
		}
		currlist.add(temp);
		return "the item added ";
	}
	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public String update(Currency temp) {
		for(Currency i :currlist) {
			if(i.getCurrencyId()==temp.getCurrencyId()) {
				currlist.remove(i);
				currlist.add(temp);
				return "<h1>currency updated</h2>";
			}
		}
		return "currency not found";
	}
	
	@GET
	@Path("/convertAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Currency> converts() {
		return currlist;
	}
	
	
	@GET
	@Path("/product/{x}/{y}")
	@Produces(MediaType.APPLICATION_JSON)
	public String product(@PathParam("x") int a,@PathParam("y") int b) {
		return "the product of "+a+" and "+b+" is "+a*b;
	}
	
}
