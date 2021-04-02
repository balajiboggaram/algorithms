/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 273 :
 * 
 * Convert a non-negative integer to its english words representation. Given
 * input is guaranteed to be less than 231 - 1.
 * 
 * Example 1:
 * 
 * Input: 123 Output: "One Hundred Twenty Three"
 * 
 * Example 2:
 * 
 * Input: 12345 Output: "Twelve Thousand Three Hundred Forty Five"
 * 
 * Example 3:
 * 
 * Input: 1234567 Output: "One Million Two Hundred Thirty Four Thousand Five
 * Hundred Sixty Seven"
 * 
 * Example 4:
 * 
 * Input: 1234567891 Output: "One Billion Two Hundred Thirty Four Million Five
 * Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 * 
 * 
 * 
 * @author bramanarayan
 * @date Jul 16, 2020
 */
public class IntegerToEnglishWords {

	final String[] ones = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
			"Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
	final String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
	final String[] thousands = { "", "Thousand", "Million", "Billion" };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IntegerToEnglishWords solution = new IntegerToEnglishWords();
		System.out.println(solution.numberToWords(2123));
	}

	
	// SHITTY PROBLEM for INTERVIEWS
	// But Interviewers are GOD, cant say - I cannot solve :(
	public String numberToWords(int num) {

		if (num == 0)
			return "Zero";

		String words = "";
		int i = 0;

		while (num > 0) {

			// indicates its greater than 1000
			if (num % 1000 != 0) {
				words = numToWord(num % 1000) + thousands[i] + " " + words;
			}
			num = num / 1000;
			i++;
		}
		return words.trim();
	}

	// the range is
	// 0, -20, -100, -1000
	public String numToWord(int n) {
		if (n == 0)
			return "";
		else if (n < 20) {
			return ones[n] + " ";
		} else if (n < 100) {
			return tens[n / 10] + " " + numToWord(n % 10);
		} else {
			return ones[n / 100] + " " + "Hundred " + numToWord(n % 100);
		}
	}

}
