/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 10 :
 * 
 *  Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

Note:

    s could be empty and contains only lowercase letters a-z.
    p could be empty and contains only lowercase letters a-z, and characters like . or *.

Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

 * 
 * @author bramanarayan
 * @date Jun 29, 2020
 */
public class RegularExpressionMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RegularExpressionMatching solution = new RegularExpressionMatching();
		System.out.println(solution.isMatch("aa", "a"));
		System.out.println(solution.isMatch("aa", "a*"));
		System.out.println(solution.isMatch("xaabyc", "xa*b*c"));

	}

	// DYNAMIC PROGRAMMING
	public boolean isMatch(String s, String p) {
		int n = s.length();
		int m = p.length();

		// this is text to pattern
		boolean[][] dp = new boolean[n + 1][m + 1];

		// DP - init
		dp[0][0] = true;
		for (int i = 1; i <= m; i++) {
			if (p.charAt(i - 1) == '*') {
				dp[0][i] = dp[0][i - 2]; // covers a*b*c* [zero occurrences of a or b or c]
			}
		}

		// DP runner
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {

				char sChar = s.charAt(i - 1);
				char pChar = p.charAt(j - 1);

				// if pattern is a . or matches with text.
				if (sChar == pChar || pChar == '.') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (pChar == '*') {
					// pattern character is a *, we have 2 cases

					// Case 1  :if zero occurence of a*
					dp[i][j] = dp[i][j - 2]; // j-2 because you need to skip a char before * for zero occurences

					// Case 2 : > 0 occurrences of a*
					if (p.charAt(j - 2) == sChar || p.charAt(j-2) == '.') {
						dp[i][j] = dp[i][j] | dp[i - 1][j]; // include the prev char (>0 a)
					}

				} else {
					dp[i][j] = false;
				}
			}
		}

		return dp[n][m];
	}

}
