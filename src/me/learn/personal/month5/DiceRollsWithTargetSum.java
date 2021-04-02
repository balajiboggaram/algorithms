/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 1155 :
 * 
 * Date : Dec 21, 2020
 * 
 * @author bramanarayan
 *
 */
public class DiceRollsWithTargetSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// count # of ways to get m
	// n dices
	// each dice has 1-m
	// x - target
	public int numRollsToTarget(int n, int m, int x) {

		if (x == 0)
			return 0;
		if (n == 1 && x < m)
			return 1;

		int[][] dp = new int[n + 1][x + 1];
		
		// only one dice here
		for(int j =1;j<=m && j <=x;j++) {
			dp[1][j]=1;
		}

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= x; j++) {
				for (int k = 1; k < j && k <= m; k++) {
					dp[i][j] += dp[i-1][j - k]; // count all k ways, 
				}

			}
		}

		return dp[n][x];

	}

}
