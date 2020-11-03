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
public class MatrixChainMultiplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Video : https://www.youtube.com/watch?v=cCgwzmHkijQ
	// GIVEN Matrix sizes in p
	// Find the minimum number of multiplications required to
	// multiply a chain on matrices
	int MatrixChainOrder(int p[]) {

		int n = p.length;

		int[][] dp = new int[n + 1][n + 1];

		// DP init
		// dp[i][j] indicates minimum number of multiplications required to multiple i
		// to j matrices
		// a matrix cannot be multipled by itself.
		for (int i = 0; i < n; i++) {
			dp[i][i] = 0;
		}

		// l is the chain length here
		for (int l = 2; l < n; l++) {
			for (int i = 1; i < n - l + 1; i++) {

				int j = i + l - 1;
				if (j == n)
					continue;
				// try any all intermediate matrices
				for (int k = i; k < j; k++) {
					int temp = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
					dp[i][j] = Math.min(temp, dp[i][j]);
				}
			}
		}

		return dp[1][n - 1];

	}

}
