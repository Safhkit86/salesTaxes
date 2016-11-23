package it.salestaxes.constants;

import java.math.BigDecimal;

/**
 * Class that contains all the constants used by the application.
 * 
 * @author ivan.savocchia
 *
 */

public class Constants {
	
	public static BigDecimal BASIC_SALES_TAX = new BigDecimal("0.1");
	public static BigDecimal IMPORT_DUTY_TAX = new BigDecimal("0.05");
	
	public enum GoodsCategories {
		BOOKS,
		FOOD,
		MEDICAL_PRODUCTS,
		OTHER
	}

}
