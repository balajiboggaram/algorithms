/**
 * 
 */
package me.learn.personal.month1;

/**
 * Title 670 :
 * 
 * Date : Jan 5, 2021
 * 
 * @author bramanarayan
 *
 */
public class MaximumNumberDigitOneSwap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	// 54367
	// firstGreater is 6. 
	// split to 2 parts - get highest in 67 -> 7
	// get highest in 543 (more than 6) -> 5
	// swap 5 and 7
	
	// you are allowed to perform one swap.
	// find the max number that you can get.
	public int maximumSwap(int num) {

		// this is similar to next bigger permutation problem.
		char[] digits = ("" + num).toCharArray();
		int firstGreaterIndex = 0; // find the first digit greater than previous
		while (++firstGreaterIndex < digits.length && digits[firstGreaterIndex - 1] >= digits[firstGreaterIndex]) ;
		
		
		if (firstGreaterIndex == digits.length)
			return num; // all digits are reversed sorted, no swap needed

		
		// get highest in second part
		char max = '0';
		int max_position = firstGreaterIndex;
		for (int i = firstGreaterIndex; i < digits.length; i++)// find max digit in remain digits
			if (max <= digits[i]) {
				max = digits[i];
				max_position = i;
			}

		// Get first smallest digit(than greater element) from left to right
		for (int i = 0; i < firstGreaterIndex; i++) // find first digit that smaller than max digit in the second part
			if (max > digits[i]) {
				StringBuilder s = new StringBuilder(String.valueOf(digits));
				s.setCharAt(max_position, digits[i]);
				s.setCharAt(i, max);
				return Integer.parseInt(s.toString()); // no need to check overflow since max value is 10^8
			}
		return num;

	}

}
