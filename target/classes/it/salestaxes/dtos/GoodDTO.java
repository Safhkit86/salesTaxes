package it.salestaxes.dtos;

import java.math.BigDecimal;

import it.salestaxes.constants.Constants.GoodsCategories;

/**
 * Class that represents a generic good.
 * 
 * @author ivan.savocchia
 *
 */

public class GoodDTO {

	private String name;
	private GoodsCategories category;
	private BigDecimal shelfPrice;
	private Boolean imported;
	
	
	/*
	 * Getters and Setters
	 */
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public GoodsCategories getCategory() {
		return category;
	}
	public void setCategory(GoodsCategories category) {
		this.category = category;
	}
	public BigDecimal getShelfPrice() {
		return shelfPrice;
	}
	public void setShelfPrice(BigDecimal shelfPrice) {
		this.shelfPrice = shelfPrice;
	}
	public Boolean getImported() {
		return imported;
	}
	public void setImported(Boolean imported) {
		this.imported = imported;
	}
	
	
	
}
