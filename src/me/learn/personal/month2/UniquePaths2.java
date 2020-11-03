/**
 * 
 */
package me.learn.personal.month2;

/**
 * Title 63 : A robot is located at the top-left corner of a m x n grid (marked
 * 'Start' in the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * 
 * 
 * @author bramanarayan
 * @date May 29, 2020
 */
public class UniquePaths2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UniquePaths2 solution = new UniquePaths2();
		System.out.println(solution.uniquePathsWithObstacles(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }));
		System.out.println(solution.uniquePathsWithObstacles(new int[][] { { 1 } }));
		System.out.println(solution.uniquePathsWithObstacles(new int[][] { { 0, 0 } }));
		System.out.println(solution.uniquePathsWithObstacles(new int[][] { { 1, 0 } }));

	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {

		int n = obstacleGrid.length;
		int m = obstacleGrid[0].length;

		int[][] res = new int[n][m];
		if (obstacleGrid[0][0] == 1)
			return 0;

		// If one blocker is found, then you cannot reach the next cell in the matrix
		boolean blocker = false;
		for (int i = 0; i < m; i++) {
			if (obstacleGrid[0][i] == 1)
				blocker = true;
			res[0][i] = blocker ? 0 : 1;
		}

		// same here on first column
		blocker = false;
		for (int i = 0; i < n; i++) {
			if (obstacleGrid[i][0] == 1)
				blocker = true;
			res[i][0] = blocker ? 0 : 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (obstacleGrid[i][j] != 1) {
					// Not an obstacle, consider in our results.
					res[i][j] = res[i][j - 1] + res[i - 1][j];
				} else {
					// this is obstacle cell, so plant a '0'
					res[i][j] = 0;
				}
			}
		}
		return res[n - 1][m - 1];
	}
}
