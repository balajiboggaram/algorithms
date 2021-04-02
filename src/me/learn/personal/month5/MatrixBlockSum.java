/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 1314 :
 * 
 * Date : Dec 31, 2020
 * 
 * @author bramanarayan
 *
 */
public class MatrixBlockSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// This is matrix block sum of range queries.
	public int[][] matrixBlockSum(int[][] mat, int K) {
		int m = mat.length;
		int n = mat[0].length;

		int[][] ans = new int[m][n];

		int[][] tpreSum = new int[m + 1][n + 1];

		// pure prefix sum computation/ rowsum + col sum
		for (int i = 1; i < tpreSum.length; i++) {
			for (int j = 1; j < tpreSum[0].length; j++) {
				tpreSum[i][j] = tpreSum[i - 1][j] + tpreSum[i][j - 1] + mat[i - 1][j - 1] - tpreSum[i - 1][j - 1];
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int r1 = Math.max(0, i - K) + 1;
				int c1 = Math.max(0, j - K) + 1;
				int r2 = Math.min(m, i + K + 1);
				int c2 = Math.min(n, j + K + 1);
				ans[i][j] = tpreSum[r2][c2] - tpreSum[r1 - 1][c2] - tpreSum[r2][c1 - 1] + tpreSum[r1 - 1][c1 - 1];
			}
		}

		return ans;
	}

}
