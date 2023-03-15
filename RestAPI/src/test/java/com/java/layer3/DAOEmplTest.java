package com.java.layer3;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.java.layer2.Currency;
import com.java.layer4.Currencynotfound;

public class DAOEmplTest {

	@Test
	public void testAllCurrecny() {
		System.out.println("testig dao started");
		CurrencyDAO currDAO = new CurrencyDAOImpl();
		
		Assert.assertTrue(currDAO!=null);
		
		List<Currency> currlist = currDAO.selectAll();
		for(Currency i : currlist) {
			System.out.println("currency :"+i);
		}
	}
	
	
	@Test
	public void testsingleCurrecny() {
		System.out.println("testig dao started");
		CurrencyDAO currDAO = new CurrencyDAOImpl();
		
		Assert.assertTrue(currDAO!=null);
		
		Currency currlist;
		try {
			currlist = currDAO.selectCurrency(1);
			Assert.assertTrue(currlist!=null);
			
			System.out.println("currency :"+currlist);
		} catch (Currencynotfound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void testaddsingleCurrecny() {
		System.out.println("testig dao started");
		CurrencyDAO currDAO = new CurrencyDAOImpl();
		
		Assert.assertTrue(currDAO!=null);
		
		Currency currlist = new Currency();
		Assert.assertTrue(currlist!=null);
		currlist.setCurrencyId(6);
		currlist.setSourceCurrency("INR");
		currlist.setTargetcurrency("FRA");
		currlist.setLoadFactor(0.0076f);
		
		currDAO.insertCurrency(currlist);
			System.out.println("currency :"+currlist);
	}
	
	@Test
	public void testUpdatesingleCurrecny() {
		System.out.println("testig dao started");
		CurrencyDAO currDAO = new CurrencyDAOImpl();
		
		Assert.assertTrue(currDAO!=null);
		
		Currency currlist = new Currency();
		Assert.assertTrue(currlist!=null);
		currlist.setCurrencyId(4);
		currlist.setSourceCurrency("USD");
		currlist.setTargetcurrency("INR");
		currlist.setLoadFactor(500);
		
		currDAO.updateCurrency(currlist);
			System.out.println("currency :"+currlist);
	}
	
	
	@Test
	public void testdeletesingleCurrecny() {
		System.out.println("testig dao started");
		CurrencyDAO currDAO = new CurrencyDAOImpl();
		
		Assert.assertTrue(currDAO!=null);
		
		currDAO.deleteCurrency(4);
			System.out.println("currency :deleted");
	}
	
	
}
