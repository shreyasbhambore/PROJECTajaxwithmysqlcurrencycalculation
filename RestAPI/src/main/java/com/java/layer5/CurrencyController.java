package com.java.layer5;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.java.layer2.Currency;
import com.java.layer4.CurrencyFoundException;
import com.java.layer4.CurrencyServiceDAOImpl;
import com.java.layer4.Currencynotfound;
import com.java.layer4.SourceNotfound;
import com.java.layer4.targateNotfound;
@Path("/Currencydb")
public class CurrencyController {

	static CurrencyServiceDAOImpl service = new CurrencyServiceDAOImpl();
	public CurrencyController() {
		System.out.println("CurrencyController constructor");
		
	}
	
	
	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Currency> getallCurrency() {
		System.out.println("currency service");
		return service.findAllCurrency();
	}
	
	
	@GET
	@Path("/convert/{src}/{trg}/{amt}")
	@Produces(MediaType.APPLICATION_JSON)
	public double convert(@PathParam("src") String s,@PathParam("trg") String t,@PathParam("amt") int a) {
		double cl=0;
		try {
			cl = service.calculate(s, t, a);
		} catch (SourceNotfound e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		} catch (targateNotfound e) {
			System.out.println(e.getMessage());
		}
		catch (Currencynotfound e) {
			System.out.println(e.getMessage());
		}

		return  cl;
		
	}
	
	
	@GET
	@Path("/getsingle/{cid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Currency getsingle(@PathParam("cid") int x) {
		
		try {
			return service.findcurrency(x);
		} catch (Currencynotfound e) {
			System.out.println("error :"+e);
			
		}
		return new Currency();
	}
	
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public String add(Currency temp) {
		try {
			service.saveCurrency(temp);
		} catch (CurrencyFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "the item added ";
	}
	
	
	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public String update(Currency temp) {
		service.updateCurrency(temp);
		return "currency updated";
	}
	
		
}
