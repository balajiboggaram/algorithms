/**
 * 
 */
package me.learn.personal.month7;

import java.util.HashMap;
import java.util.Map;

/**
 * Title 166 :
 * 
 * Date : Feb 16, 2021
 * 
 * @author bramanarayan
 *
 */
public class FractionToRecurringDecimal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// CONVERT FRACTION TO A DECIMAL
	public String fractionToDecimal(int numerator, int denominator) {
		
		if (numerator == 0) {
			return "0";
		}
		
		StringBuilder fraction = new StringBuilder();

		// If either one is negative (not both)
		if (numerator < 0 ^ denominator < 0) { // use ||
			fraction.append("-");
		}
		
		// Convert to Long or else abs(-2147483648) overflows
		long dividend = Math.abs(Long.valueOf(numerator));
		long divisor = Math.abs(Long.valueOf(denominator));
		
		fraction.append(String.valueOf(dividend / divisor));
		
		long remainder = dividend % divisor;
		
		if (remainder == 0) {
			return fraction.toString();
		}
		
		// Decimal part
		fraction.append(".");
		Map<Long, Integer> map = new HashMap<>();
		while (remainder != 0) {
			if (map.containsKey(remainder)) {
				fraction.insert(map.get(remainder), "(");
				fraction.append(")");
				break;
			}
			map.put(remainder, fraction.length()); // length of reaminer so that you can insert ( at fraction position
			remainder *= 10;
			fraction.append(String.valueOf(remainder / divisor));
			remainder %= divisor;
		}
		return fraction.toString();
	}

}
