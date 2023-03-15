package com.java.layer4;

import java.util.List;

import com.java.layer2.Currency;

public interface CurrrencyServiceDOA {

	List<Currency> findAllCurrency();
	Currency findcurrency(int id)throws Currencynotfound;
	
	void saveCurrency(Currency temp)throws CurrencyFoundException;
	void updateCurrency(Currency temp);
	void deleteCurrency(int id);
	
	double calculate(String s,String t,int amount) throws SourceNotfound,targateNotfound,Currencynotfound;
}
