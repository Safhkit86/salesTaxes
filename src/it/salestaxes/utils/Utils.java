package it.salestaxes.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Class that contains util methods used by the application.
 * 
 * @author ivan.savocchia
 *
 */

public class Utils {

	public static BigDecimal NEAREST_005_ROUNDING_FACTOR = new BigDecimal("0.05");
	
	/**
	 * Method that rounds the amount passed as input parameter to the 
	 * nearest 0.05.
	 * 
	 * @param amount	Amount to round.
	 * @return			Amount rounded.
	 */
	
	public static BigDecimal round(BigDecimal amount) {
		
		if (amount == null) {
			amount = BigDecimal.ZERO;
		}
		
        BigDecimal rounded = amount.divide(NEAREST_005_ROUNDING_FACTOR, 9, RoundingMode.HALF_EVEN);
        rounded = rounded.setScale(0, RoundingMode.HALF_UP).multiply(NEAREST_005_ROUNDING_FACTOR);
	
		return rounded;
	}
}
