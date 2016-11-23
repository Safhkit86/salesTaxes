package it.salestaxes.dtos;

import java.math.BigDecimal;

/**
 * Class that represents the generated receipt.
 * 
 * @author ivan.savocchia
 *
 */

public class ReceiptDTO {
	
	private BasketDTO basket;
	private BigDecimal salesTaxes;
	private BigDecimal total;
	
	
	/*
	 * Getters and Setters.
	 */
	
	public BasketDTO getBasket() {
		return basket;
	}
	public void setBasket(BasketDTO basket) {
		this.basket = basket;
	}
	public BigDecimal getSalesTaxes() {
		return salesTaxes;
	}
	public void setSalesTaxes(BigDecimal salesTaxes) {
		this.salesTaxes = salesTaxes;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}	
}
