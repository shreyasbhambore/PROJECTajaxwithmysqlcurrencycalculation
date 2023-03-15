package com.java.layer2;

public class Currency {
	private int currencyId;
	private String sourceCurrency;
	private String targetcurrency;
	private float loadFactor;
	
	
	
	public Currency() {
	}
	public int getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}
	public String getSourceCurrency() {
		return sourceCurrency;
	}
	public void setSourceCurrency(String sourceCurrency) {
		this.sourceCurrency = sourceCurrency;
	}
	public String getTargetcurrency() {
		return targetcurrency;
	}
	public void setTargetcurrency(String targetcurrency) {
		this.targetcurrency = targetcurrency;
	}
	
	public float getLoadFactor() {
		return loadFactor;
	}
	public void setLoadFactor(float loadFactor) {
		this.loadFactor = loadFactor;
	}
	@Override
	public String toString() {
		return "Currency [currencyId=" + currencyId + ", sourceCurrency=" + sourceCurrency + ", targetcurrency="
				+ targetcurrency + ", loadFactor=" + loadFactor + "]";
	}
	

}
