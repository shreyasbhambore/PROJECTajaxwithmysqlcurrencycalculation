package com.java.layer3;

import java.util.List;


import org.junit.Assert;
import org.junit.Test;


import com.java.layer2.Currency;
import com.java.layer4.CurrencyFoundException;
import com.java.layer4.CurrencyServiceDAOImpl;
import com.java.layer4.Currencynotfound;
import com.java.layer4.SourceNotfound;
import com.java.layer4.targateNotfound;

public class CurrencyServiceDAOImpleTest {
	CurrencyServiceDAOImpl imp= new CurrencyServiceDAOImpl();
	@Test
	public void testAllCurrecny() {
		System.out.println("testig dao started");
		
		Assert.assertTrue(imp!=null);
		
		List<Currency> currlist = imp.findAllCurrency();
		for(Currency i : currlist) {
			System.out.println("currency :"+i);
		}
	}
	
	@Test
	public void getsingetest() {
		System.out.println("testig dao started");
		
		Assert.assertTrue(imp!=null);
	     
		try {
			Currency cur = imp.findcurrency(1);
			System.out.println(cur);
		} catch (Currencynotfound e) {
			// TODO Auto-generated catch block
			System.out.println("error: "+e);
		}
	
	}
	
	@Test
	public void addtest() {
		System.out.println("testig dao started");
		
		Assert.assertTrue(imp!=null);
		
		Currency cur = new Currency();
		cur.setSourceCurrency("FRA");
		cur.setTargetcurrency("INR");
		cur.setLoadFactor(88.50f);
		
		try {
			imp.saveCurrency(cur);
		} catch (CurrencyFoundException e) {
			System.out.println("error"+e);
		}
	}
	
	
	@Test
	public void testcalulate(){
		System.out.println("testig dao started");
		
		Assert.assertTrue(imp!=null);
		
		double reuslt;
		try {
			reuslt = imp.calculate("INR", "COM", 500);
			System.out.println(reuslt);
		} catch (SourceNotfound e) {
			
			System.out.println(e.getMessage());
		} catch (targateNotfound e) {
			System.out.println(e.getMessage());
		}catch (Currencynotfound e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
}
