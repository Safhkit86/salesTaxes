package it.salestaxes.utils;

import it.salestaxes.dtos.BasketDTO;
import it.salestaxes.dtos.GoodDTO;

/**
 * Class that contains the validation methods for application's methods input 
 * parameters.
 * 
 * @author ivan.savocchia
 *
 */

public class Validation {

	/**
	 * Validation method for the input of TaxCalculator.calculateTaxes method.
	 * 
	 * @param input			Input parameter to validate.
	 * @throws Exception	Exception thrown if the validation doesn't finish 
	 * 						correctly.
	 */
	
	public static void validateCalculateTaxes(GoodDTO input) throws Exception {
		if (input == null) {
			throw new Exception("The good on which to calculate taxes cannot "
					+ "be null.");
		}
		
		if (input.getName() == null) {
			throw new Exception("The name of the good on which to calculate "
					+ "taxes cannot be null.");
		}
		
		if (input.getCategory() == null) {
			throw new Exception("The category of the good on which to "
					+ "calculate taxes cannot be null.");
		}
		
		if (input.getImported() == null) {
			throw new Exception("The imported flag of the good on which to "
					+ "calculate taxes cannot be null.");
		}
		
		if (input.getShelfPrice() == null) {
			throw new Exception("The shelf proce of the good on which to "
					+ "calculate taxes cannot be null.");
		}
	}
	
	
	/**
	 * Validation method for the input of ReceiptGenerator.generateReceipt 
	 * method.
	 * 
	 * @param input			Input parameter to validate. 
	 * @throws Exception	Exception thrown if the validation doesn't finish 
	 * 						correctly.
	 */
	
	public static void validateGenerateReceipt(BasketDTO input) throws Exception{
		if (input == null) {
			throw new Exception("The basket of goods on which to calculate "
					+ "taxes cannot be null.");
		}
		
		if (input.getGoods() == null) {
			throw new Exception("The basket of goods on which to calculate "
					+ "taxes cannot have a null goods list.");
		}
	}
}
