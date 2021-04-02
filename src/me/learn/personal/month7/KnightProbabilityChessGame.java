/**
 * 
 */
package me.learn.personal.month7;

/**
 * Title 688 :
 * 
 * Date : Mar 8, 2021
 * 
 * @author bramanarayan
 *
 */
public class KnightProbabilityChessGame {

	public double knightProbability(int N, int K, int r, int c) {
		if (r < 0 || N < r || c < 0 || N < c)
			return 0;

		int[][] dirs = new int[][] { { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 },
				{ -1, -2 } };
		double[][] dp = new double[N][N]; // dp[i][j] is the probability that the knight is on position (i,j).
		dp[r][c] = 1;
		double result = 1; // We maintain the sum of all probabilities in the current dp array.

		for (int i = 0; i < K; ++i) {
			double[][] newDP = new double[N][N]; // newDP[i][j] is the probability that the knight is on position (i,j)
													// after the current i-th move.
			double newResult = 0; // sum of all probabilities in the new dp array.
			for (int row = 0; row < dp.length; ++row) {
				for (int col = 0; col < dp[0].length; ++col) {
					if (dp[row][col] != 0) {
						// Try moving the knight from the current position (row,col) to the 8 possible
						// positions.
						for (int[] dir : dirs) {
							int newRow = row + dir[0];
							int newCol = col + dir[1];
							if (0 <= newRow && newRow < N && 0 <= newCol && newCol < N) {
								newDP[newRow][newCol] += dp[row][col] / 8.0;
								newResult += dp[row][col] / 8.0;
							}
						}
					}
				}
			}
			dp = newDP;
			result = newResult;
		}
		return result;
	}

}
