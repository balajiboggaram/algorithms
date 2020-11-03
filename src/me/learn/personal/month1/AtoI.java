package me.learn.personal.month1;

/**
 * 
 * Title : Converts String to Integer
 * 
 * @author bramanarayan
 * @date Apr 21, 2020
 */
public class AtoI {

	public static void main(String args[]) {

		/*
		 * myAtoi("42"); myAtoi("65643"); myAtoi("78   "); myAtoi("   6888");
		 * myAtoi("-42");
		 */

		myAtoi("42");
		myAtoi("-42");
		myAtoi("   78");
		myAtoi("  7455  ");
		myAtoi("asd");
		myAtoi("123sdf89");
		myAtoi("-91283472332");
	}

		/**
		 * Working solution
		 */
	
		public static int myAtoi(String str) {
			if (str.isEmpty()) {
				return 0;
			}
	
			// trim the input string
			String input = str.trim();
	
			int i = 0, sign = 1, result = 0;
			int n = input.length();
	
			if (i < n && input.charAt(i) == '-') {
				sign = -1;
				i++;
			} else if (i < n && input.charAt(i) == '+') {
				sign = 1;
				i++;
			}
	
			while (i < n) {
				int value = (int) input.charAt(i) - '0';
	
				if (value < 0 || value > 9) { // Check if there are any non-numbers
					System.out.println("Invalid Number");
					return result * sign;
				}
	
				// Check for any strings with out of integer bounds. 
				if (Integer.MAX_VALUE / 10 < result || Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < value)
					return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
	
				result = 10 * result + value; // base * result + digit
	
				i++;
			}
	
			System.out.println(" The Result is : " + result * sign);
			return result * sign;
		}

}
