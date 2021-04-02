/**
 * 
 */
package me.learn.personal.month3;

import java.util.Arrays;

/**
 * Title 913 :
 * 
 * Date : Jan 1, 2021
 * 
 * @author bramanarayan
 *
 */
public class MinimumFallingPathSumInMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MinimumFallingPathSumInMatrix solution = new MinimumFallingPathSumInMatrix();
		System.out.println(solution.minFallingPathSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
	}

	// Dynamic Programming
	public int minFallingPathSum(int[][] a) {
		System.out.println("hello");

		int m = a.length;
		int n = a[0].length;

		int[][] dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0) {
					dp[i][j] = a[i][j];
					continue;
				}

				// top left
				int result = Integer.MAX_VALUE;
				if (i > 0 && j - 1 >= 0) {
					result = Math.min(result, dp[i - 1][j - 1]);
				}

				// immediate top
				if (i > 0 && j >= 0) {
					result = Math.min(result, dp[i - 1][j]);
				}

				// top right
				if (i > 0 && j + 1 < n) {
					result = Math.min(result, dp[i - 1][j]);
				}

				dp[i][j] = result + a[i][j];

			}

		}

		// now, find the minimum in last row
		int result = Integer.MAX_VALUE;
		for (int j = 0; j < n; j++) {
			result = Math.min(result, dp[m - 1][j]);
		}
		return result;
	}

}
