/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 1016 :
 * 
 * Binary String With Substrings Representing 1 To N Medium
 * 
 * Given a binary string S (a string consisting only of '0' and '1's) and a
 * positive integer N, return true if and only if for every integer X from 1 to
 * N, the binary representation of X is a substring of S.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: S = "0110", N = 3 Output: true
 * 
 * Example 2:
 * 
 * Input: S = "0110", N = 4 Output: false
 * 
 * 
 * @author bramanarayan
 * @date Jun 29, 2020
 */
public class BinaryStringWithSubStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryStringWithSubStrings solution = new BinaryStringWithSubStrings();
		System.out.println(solution.queryString("0110", 3));
		System.out.println(solution.queryString("0110", 4));

	}

	// CHECK ONLY UNTIL n/2. i.e enough 
	// Why ?  Cos The binary representation for every count 0 to n/2 
	// will just be a substring from n/2 to n.so....
	public boolean queryString(String s, int n) {
		
		int count = n;
		while(count > n/2) { 
			String temp = Integer.toBinaryString(count);
			if(s.indexOf(temp) == -1)
				return false;
			count--;
		}
		return true;	
	}

}
