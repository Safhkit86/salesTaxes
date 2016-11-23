package it.salestaxes.dtos;

import java.util.List;

/**
 * Class that represents a basket with one or more goods on which to calculate 
 * taxes and to generate the purchase receipt.
 * 
 * @author ivan.savocchia
 *
 */

public class BasketDTO {
	private List<GoodDTO> goods;

	
	/*
	 * Getters and Setters
	 */
	
	public List<GoodDTO> getGoods() {
		return goods;
	}

	public void setGoods(List<GoodDTO> goods) {
		this.goods = goods;
	}
	
	
}
