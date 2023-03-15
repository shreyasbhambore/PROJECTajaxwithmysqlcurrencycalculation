package com.java.layer3;

import java.util.List;

import com.java.layer2.Currency;
import com.java.layer4.Currencynotfound;

public interface CurrencyDAO {

	Currency selectCurrency(int id)throws Currencynotfound;
	List<Currency> selectAll();
	void insertCurrency(Currency temp);
	void updateCurrency(Currency temp);
	void deleteCurrency(int id);
}
