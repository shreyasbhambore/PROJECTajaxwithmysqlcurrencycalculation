package com.java.layer4;

import java.util.List;

import com.java.layer2.Currency;
import com.java.layer3.CurrencyDAOImpl;

public class CurrencyServiceDAOImpl implements CurrrencyServiceDOA  {

	CurrencyDAOImpl imple = new CurrencyDAOImpl();
	@Override
	public List<Currency> findAllCurrency() {	
		return imple.selectAll();
	}

	@Override
	public Currency findcurrency(int id) throws Currencynotfound {
		return imple.selectCurrency(id);
	}

	@Override
	public void saveCurrency(Currency temp) throws CurrencyFoundException {
		
		boolean found = false;
		List<Currency> list = imple.selectAll();
		for(Currency i:list) {
			if(i.getSourceCurrency().equals(temp.getSourceCurrency()) && i.getTargetcurrency().equals(temp.getTargetcurrency())) {
				found = true;
				break;
			}
		}
		if(!found) {
			imple.insertCurrency(temp);
		}else {
			throw new CurrencyFoundException("currency found exception");
		}
		
		
	}

	@Override
	public void updateCurrency(Currency temp) {
		imple.updateCurrency(temp);

	}

	@Override
	public void deleteCurrency(int id) {
		imple.deleteCurrency(id);

	}

	@Override
	public double calculate(String s, String t, int amount) throws SourceNotfound, targateNotfound,Currencynotfound {
		
		boolean sourcefound=false;
		boolean targetfound=false;
		double calcamount=0;
		List<Currency> l= imple.selectAll();
		for(Currency i : l) {
			if(i.getSourceCurrency().equals(s)) {
				sourcefound = true;
				if(i.getTargetcurrency().equals(t)) {
					targetfound = true;
					float load = i.getLoadFactor();
					calcamount= load*amount;
					break;
				}
			}
		    targetfound=false;			
		}
		
		if(!sourcefound && !targetfound)throw new Currencynotfound("currency not found");
		
		if(!sourcefound)throw new SourceNotfound("source not found ");
		
		if(!targetfound)throw new targateNotfound("target not found ");
		
		
		return calcamount;
	}
		

}
