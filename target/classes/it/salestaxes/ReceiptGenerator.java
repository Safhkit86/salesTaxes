package it.salestaxes;

import java.math.BigDecimal;
import java.util.List;

import it.salestaxes.calculator.TaxCalculator;
import it.salestaxes.dtos.BasketDTO;
import it.salestaxes.dtos.GoodDTO;
import it.salestaxes.dtos.ReceiptDTO;
import it.salestaxes.utils.Validation;

/**
 * Class that represents the receipt generator that elaborates a basket of 
 * goods, calculate the right amount of taxes and generates a purchase receipt.
 * 
 * @author ivan.savocchia
 *
 */

public class ReceiptGenerator {

	/**
	 * Method that elaborates a basket of goods, calculate the right amount of 
	 * taxes and generates a purchase receipt.
	 * 
	 * @param basket	Basket of goods for which calculates taxes.
	 * @return			The generated receipt.
	 */
	
	public static ReceiptDTO generateReceipt(BasketDTO basket) throws Exception {
		
		//input validation
		Validation.validateGenerateReceipt(basket);
		
		StringBuilder sb = new StringBuilder();		
		List<GoodDTO> goods = basket.getGoods();
		
		BigDecimal totalTaxes = BigDecimal.ZERO;
		BigDecimal totalCost =  BigDecimal.ZERO;
		
		for (GoodDTO good : goods) {
			BigDecimal taxes = TaxCalculator.calculateTaxes(good);
			totalTaxes = totalTaxes.add(taxes);
			BigDecimal cost = good.getShelfPrice().add(taxes);
			
			sb.append("1 ");
			if (good.getImported()) {
				sb.append("imported ");
			}
			sb.append(good.getName() + ": ");
			sb.append(cost + System.getProperty("line.separator"));
			
			totalCost = totalCost.add(cost);
		}
		
		sb.append("Sales Taxes: " + totalTaxes);
		sb.append(System.getProperty("line.separator"));
		sb.append("Total: " + totalCost);
		
		sb.append(System.getProperty("line.separator"));
		sb.append(System.getProperty("line.separator"));
		System.out.println(sb.toString());
		
		
		ReceiptDTO receipt = new ReceiptDTO();
		receipt.setBasket(basket);
		receipt.setSalesTaxes(totalTaxes);
		receipt.setTotal(totalCost);
		
		return receipt;
	}
	
}
