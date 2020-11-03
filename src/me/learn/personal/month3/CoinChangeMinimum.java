/**
 * 
 */
package me.learn.personal.month3;

import java.util.Arrays;

/**
 * Title :
 * 
 * @author bramanarayan
 * @date Jul 6, 2020
 */
public class CoinChangeMinimum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CoinChangeMinimum solution = new CoinChangeMinimum();
		System.out.println(solution.coinChange(new int[] {1,2,5}, 11));
		System.out.println(solution.coinChange(new int[] {2}, 3));

	}

	// Space Optimized way
	// Minimum coins required for a given change
	public int coinChange(int[] coins, int n) {

		int m = coins.length;

		// DP init
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		// DP runner
		for (int i = 0; i < m; i++) {
			for (int j = 1; j <= n; j++) {
				if(coins[i] <= j) {
					
					// check of max value cos - its no point in considering it as 
					// result - as there is no solution from that j-coins[i] index
					if (dp[j - coins[i]] != Integer.MAX_VALUE && dp[j] > dp[j-coins[i]] + 1) {
						dp[j] = dp[j - coins[i]] + 1;
					}
				}
			}
		}

		return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
	}

}
