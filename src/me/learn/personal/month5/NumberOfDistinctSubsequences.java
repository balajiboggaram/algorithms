/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 115 :
 * 
 * Date : Dec 23, 2020
 * 
 * @author bramanarayan
 *
 */
public class NumberOfDistinctSubsequences {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Find the number of distinct subsequences of s which equals to t
		// rabbbit, rabbit op = 3
		public int numDistinct(String s, String t) {

			int m = s.length();
			int n = t.length();
			if (n > m)
				return 0;

			int[][] dp = new int[m + 1][n + 1];

			// empty s case
			for (int j = 0; j <= n; j++) {
				dp[0][j] = 0;
			}

			for (int i = 0; i <= m; i++) {
				dp[i][0] = 1;
			}

			for (int i = 1; i <= m; i++) {
				for (int j = 1; j <= n; j++) {
					if (s.charAt(i-1) == t.charAt(j-1)) {
						dp[i][j] = dp[i-1][j ] + dp[i - 1][j - 1];

					} else {
						dp[i][j] = dp[i-1][j];
					}
				}
			}

			return dp[m][n];

		}
}
