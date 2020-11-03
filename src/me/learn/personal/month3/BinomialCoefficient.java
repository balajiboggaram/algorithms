/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title :
 * 
 * @author bramanarayan
 * @date Jul 7, 2020
 */
public class BinomialCoefficient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinomialCoefficient solution = new BinomialCoefficient();
		System.out.println(solution.binomialCoeffecient(5, 2));
		System.out.println(solution.binomialCoeffecient(1, 1));
		System.out.println(solution.binomialCoeffecient(3, 1));
		System.out.println(solution.binomialCoeffecient(4, 2));

	}

	/**
	 * Indicates how many way can you pick 'k' element out of 'n' elements; DYNAMIC
	 * PROGRAMMING
	 */
	public int binomialCoeffecient(int n, int k) {
		if (k == 0 || n == k)
			return 1;

		int[][] dp = new int[n + 1][k + 1];

		dp[0][0] = 1;

		// DP init
		for (int i = 1; i <= n; i++) {
			dp[i][0] = 1;
		}
		
		for (int i = 1; i <= k; i++) {
			dp[0][i] = 0;
		}

		// THIS can be space optimized as we always need only previous row at any given
		// time.
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (i == j)
					dp[i][j] = 1;
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}
		return dp[n][k];
	}
}