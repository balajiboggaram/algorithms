/**
 * 
 */
package me.learn.personal.month3;

import java.math.BigInteger;

/**
 * Title 67 :
 * 
 *  Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"

Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 * 
 * @author bramanarayan
 * @date Jun 29, 2020
 */
public class AddBinary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AddBinary solution = new AddBinary();
		System.out.println(solution.addBinary("11", "1"));
		System.out.println(solution.addBinary("1010", "1011"));

	}

	// BUT IN FACEBOOK, THEY USUALLY TELL TO AVOID ADDITION 
	public String addBinary(String a, String b) {
		BigInteger x = new BigInteger(a, 2);
		BigInteger y = new BigInteger(b, 2);
		BigInteger zero = new BigInteger("0", 2);
		BigInteger carry, answer;
		while (y.compareTo(zero) != 0) {
			answer = x.xor(y);
			carry = x.and(y).shiftLeft(1);
			x = answer;
			y = carry;
		}
		return x.toString(2);
	}
	
	// ADDITION ALLOWED
	public String addBinaryMy(String a, String b) {
		int m = a.length();
		int n = b.length();

		int c = 0, s = 0;
		StringBuilder sb = new StringBuilder();
		int i = m - 1, j = n - 1;
		while (i >= 0 || j >= 0) {
			int x = i >= 0 ? a.charAt(i) - '0' : 0;
			int y = j >= 0 ? b.charAt(j) - '0': 0;
			s = x + y + c;
			sb.append(s % 2);
			c = s /2;
			i--;
			j--;
		}
		if(c > 0) {
			sb.append(c);
		}
		return sb.reverse().toString();

	}

}
