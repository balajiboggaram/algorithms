package me.learn.personal.month3;

/**
 * 
 * Title 44 : 
 * 
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

Note:

    s could be empty and contains only lowercase letters a-z.
    p could be empty and contains only lowercase letters a-z, and characters like ? or *.

Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:

Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.

Example 3:

Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

 * 
 * @author bramanarayan
 * @date Jun 29, 2020
 */
public class WildCardMatching {

	public static void main(String[] args) {
		WildCardMatching solution = new WildCardMatching();
		System.out.println(solution.isMatch("adceb", "*a*b"));
		System.out.println(solution.isMatch("acdcb", "a*c?b"));
		
	}

	// DYNAMIC PROGRAMMING
	public boolean isMatch(String s, String p) {

		int n = s.length();
		int m = p.length();

		boolean[][] dp = new boolean[n + 1][m + 1];

		// DP - init
		dp[0][0] = true;
		for (int j = 1; j <= m; j++) {
			if(p.charAt(j-1) == '*') {
				dp[0][j] = dp[0][j-1];
			}
		}

		// DP - runner
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				
				char sChar = s.charAt(i-1);
				char pChar = p.charAt(j-1);
				
				if(sChar == pChar || pChar == '?') {
					dp[i][j] = dp[i-1][j-1];
				} else if( pChar == '*') {
					
					// 2 cases - either you ignore the * or you ignore the character
					dp[i][j] = dp[i-1][j] | dp[i][j-1];
					
				} else {
					dp[i][j] = false;
				}
				
			}
		}
		
		return dp[n][m];

	}

}
