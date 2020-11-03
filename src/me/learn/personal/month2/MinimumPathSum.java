package me.learn.personal.month2;

/**
 * 
 * Title 64 : 
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum. 
 * 
 * @author bramanarayan
 * @date May 24, 2020
 */
public class MinimumPathSum {

	public static void main(String args[]) {
		MinimumPathSum solution = new MinimumPathSum();
		System.out.println(solution.minPathSum(new int[][] {{1,3,1},{1,5,1},{4,2,1}}));
	}

	public int minPathSum(int[][] a) {

		int m = a.length;
		if (m == 0)
			return 0;

		int n = a[0].length;

		int[][] dp = new int[m][n];
		dp[0][0] = a[0][0];
		
		// init dp's first row and first column
		for (int i = 1; i < m; i++) {
			dp[i][0] = dp[i - 1][0] + a[i][0]; // first column
		}
		for (int i = 1; i < n; i++) {
			dp[0][i] = dp[0][i - 1] + a[0][i]; // first row here
		}

		// Lets start the DP beauty here
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + a[i][j];
			}
		}

		return dp[m - 1][n - 1];

	}

}
