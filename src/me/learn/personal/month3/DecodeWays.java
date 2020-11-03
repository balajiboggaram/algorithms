/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 91 :
 * 
 *  A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).

Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).


 * 
 * @author bramanarayan
 * @date Jul 20, 2020
 */
public class DecodeWays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DecodeWays solution = new DecodeWays();
		System.out.println(solution.numDecodings("12"));
	}

	// DYNAMIC PROGRAMMING
	public int numDecodings(String s) {
		int n = s.length();
		int[] dp = new int[n + 1];

		dp[0] = 1; // empty string - can decode only one way
		dp[1] = s.charAt(0) == '0' ? 0 : 1; // // Ways to decode a string of size 1 is 1. Unless the string is '0'.
        // '0' doesn't have a single digit decode.
		for (int i = 2; i <= n; i++) {
			
			// for i, we need to check i-1 character in string 's'
			if(s.charAt(i-1) != '0')
			dp[i] = dp[i] + dp[i-1];
			
			// check for 2 digit now, i-1 and i-2 character
			// there would be additional ways to reach here only if the current digit is considered
			// to the previous digit, then the range is between 10 to 26, extra way to reach here.
			int value = Integer.parseInt(s.substring(i-2, i));
			if(value >= 10 && value <= 26) {
				dp[i] = dp[i] + dp[i-2];
			}
		}
		
		return dp[n];

	}

}
