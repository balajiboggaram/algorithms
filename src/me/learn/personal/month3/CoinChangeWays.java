/**
 * 
 */
package me.learn.personal.month3;

import java.util.Arrays;

/**
 * Title 322 :
 * 
	 # of ways to give the change
 * 
 * 
 * @author bramanarayan
 * @date Jul 6, 2020
 */
public class CoinChangeWays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CoinChangeWays solution = new CoinChangeWays();
		System.out.println(solution.coinChange(new int[] {1,5,10}, 12));
		System.out.println(solution.coinChangeSpaceOPtimized(new int[] {1,5,10}, 12));

	}
	
	// NUMBER OF WAYS you can give back the CHANGE
	public int coinChange(int[] coins, int n) {

		int m = coins.length;

		// DP init
		int[][] dp = new int[m+1][n+1];
		dp[0][0] = 1;
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}

		// DP runner
		for (int i = 1; i <= m; i++) {

			for (int j = 1; j <= n; j++) {
			
				if(coins[i-1] > j ) { // if coin value is greater than change
					dp[i][j] = dp[i-1][j];
				} else {
					//dp[i-1][j] - exclude that ith coin
					// dp[i][j-coins[i]] - include the ith coins
					dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
				}
			}
		}
		
		return dp[m][n];
	}
	
	// OR SIMPLER VERSION

	public int change(int amount, int[] coins) {
		int n = amount;
		int m = coins.length;

		// DP init
		int[] dp = new int[n + 1];
		Arrays.fill(dp, 0);
		dp[0] = 1; // if the amount is 0, we have one way to return. i.e nothing to return

		for (int i = 0; i < m; i++) {
			for (int j = coins[i]; j <= n; j++) {
				dp[j] = dp[j] + dp[j - coins[i]];
			}
		}

		return dp[n];
	}
	
	// Space Optimized way
	public int coinChangeSpaceOPtimized(int[] coins, int n) {

		int m = coins.length;

		// DP init
		int[] dp = new int[n + 1];
		dp[0] = 1;

		// DP runner
		for (int i = 0; i < m; i++) {
			for (int j = coins[i]; j <= n; j++) {
				// dp[j] - number of ways by excluding the ith coin
				// dp [j-coins[i]] - number od ways by including the ith coin
				dp[j] = dp[j] + dp[j - coins[i]];
			}
		}

		return dp[n];
	}

}
