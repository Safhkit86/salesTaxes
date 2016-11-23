package it.salestaxes.calculator;

import java.math.BigDecimal;

import it.salestaxes.constants.Constants;
import it.salestaxes.dtos.GoodDTO;
import it.salestaxes.utils.Utils;
import it.salestaxes.utils.Validation;

/**
 * Class that represents the tax calculator.
 * 
 * @author ivan.savocchia
 *
 */

public class TaxCalculator {
	
	/**
	 * Method that calculate the amount of taxes for the good passed as input
	 * parameter.
	 * 
	 * @param good	The good for which calculate the amount of taxes to pay.
	 * @return		Total amounts of taxes to pay.
	 */
	
	public static BigDecimal calculateTaxes(GoodDTO good) throws Exception{
		
		//input validation
		Validation.validateCalculateTaxes(good);
		
		BigDecimal totalTaxes = BigDecimal.ZERO;
		BigDecimal price = good.getShelfPrice();
		
		//sales taxes calculation
		switch (good.getCategory()) {
			case OTHER:
					totalTaxes = price.multiply(Constants.BASIC_SALES_TAX);
				
				break;
				
			default:
				break;
		}
		
		//rounding taxes to nearest 0.05
		totalTaxes = Utils.round(totalTaxes);
		
		//import duty calculation
		if (good.getImported()) {
			BigDecimal importDuty = price.multiply(Constants.IMPORT_DUTY_TAX);
			
			//rounding taxes to nearest 0.05
			importDuty = Utils.round(importDuty);
			totalTaxes = totalTaxes.add(importDuty);
		}
		
		return totalTaxes;
	}
	
	
	
}
