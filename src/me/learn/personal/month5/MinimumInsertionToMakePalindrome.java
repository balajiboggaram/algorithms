/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 1312:
 * 
 * Date : Dec 21, 2020
 * 
 * @author bramanarayan
 *
 */
public class MinimumInsertionToMakePalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	// Find the LCS of reverse(s) and S
	// return length(s) - LCS = result
	public int minInsertions(String s) {
		
		if(s == null) return 0;
		if(s.length() ==  1) return 0;
		
		String reverseStr = new StringBuilder(s).reverse().toString();
		int lcsLength = longestCommonSubsequence(s, reverseStr);
		return s.length() - lcsLength;
		
	}

	// DYNAMIC PROGRAMMING
	public int longestCommonSubsequence(String s1, String s2) {

		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m + 1][n + 1];

		// DP init
		// an empty string on s1 or s2 will have 0 as max sub sequence
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				}
			}
		}

		// DP runner
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {

				char x = s1.charAt(i - 1);
				char y = s2.charAt(j - 1);

				if (x == y) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[m][n];

	}
}
