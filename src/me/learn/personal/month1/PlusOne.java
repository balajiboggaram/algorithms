package me.learn.personal.month1;

import java.util.Arrays;

/**
 * 
 * Title 66 : Given a non-empty array of digits representing a non-negative
 * integer, plus one to the integer.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list, and each element in the array contain a single digit.
 * 
 * You may assume the integer does not contain any leading zero, except the
 * number 0 itself.
 * 
 * @author bramanarayan
 * @date May 18, 2020
 */
public class PlusOne {

	public static void main(String args[]) {

		PlusOne solution = new PlusOne();
		System.out.println(Arrays.toString(solution.plusOne(new int[] { 1, 2, 3 })));
		System.out.println(Arrays.toString(solution.plusOne(new int[] { 4, 3, 2, 1 })));
		System.out.println(Arrays.toString(solution.plusOne(new int[] { 9 })));
		System.out.println(Arrays.toString(solution.plusOne(new int[] { 9, 9 })));
		System.out.println(Arrays.toString(solution.plusOne(new int[] { 0 })));
		System.out.println(Arrays.toString(solution.plusOne(new int[] { 8, 9, 9, 9 })));

	}

	/**
	 * Instead of having result, we can also inplace replace the digits array 	 
	 */
	public int[] plusOne(int[] digits) {
		int n = digits.length;
		int[] result = new int[n + 1];
		int carry = 1;
		for (int i = n - 1; i >= 0; i--) {
			int sum = digits[i] + carry;
			result[i + 1] = sum % 10;
			carry = sum / 10;
		}
		if (carry > 0) {
			result[0] = carry;
		}
		return result[0] == 0 ? Arrays.copyOfRange(result, 1, n+1) : result;

	}
}
