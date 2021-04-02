/**
 * 
 */
package me.learn.personal.month6;

import java.util.ArrayList;
import java.util.List;

/**
 * Title 564 :
 * 
 * Date : Feb 7, 2021
 * 
 * @author bramanarayan
 *
 */
public class FindClosestPalindromeNumberInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * get first half, then compare 5 cases:
	 * 
	 * +0(itself not palindrome), +1 -1 9...9 10..01 (itself palindrome)
	 */

	public String nearestPalindromic(String number) {

		int len = number.length();

		boolean isEven = len % 2 == 0;

		// mid point based on odd or even
		int mid = isEven ? len / 2 - 1 : len / 2;

		// grab left half of the string
		long left = Long.parseLong(number.substring(0, mid + 1));

		// input: n 12345
		List<Long> candidate = new ArrayList<>();
		candidate.add(getPalindrome(left, isEven)); // 12321
		candidate.add(getPalindrome(left + 1, isEven)); // 12421
		candidate.add(getPalindrome(left - 1, isEven)); // 12221
		candidate.add((long) Math.pow(10, len - 1) - 1); // 9999
		candidate.add((long) Math.pow(10, len) + 1); // 100001

		long diff = Long.MAX_VALUE, res = 0;
		Long numberLong = Long.parseLong(number);

		for (int i = 0; i < candidate.size(); i++) {
			long cand = candidate.get(i);
			
			if (cand == numberLong)
				continue; // if candidate is same as the given input number

			long curDiff = Math.abs(cand - numberLong);
			
			if (diff > curDiff) {
				diff = cand - numberLong;
				res = cand;
			} else if (diff == curDiff) {
				res = Math.min(res, cand); // if the diffs are same -> you need to pick the lowest number, this is a
											// wierd requirement
			}

		}

		return String.valueOf(res);

	}

	// return the palindrome of left, thats it !!
	// odd case : 123 --> 21
	// even case : 1234 -> 4321
	private long getPalindrome(long left, boolean even) {
		long res = left;

		if (!even)
			left = left / 10;

		while (left > 0) {
			long digit = left % 10;
			res = res * 10 + digit;
			left = left / 10;
		}

		return res;
	}

}
