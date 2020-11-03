/**
 * 
 */
package me.learn.personal.month2;

/**
 * Title 62 : A robot is located at the top-left corner of a m x n grid (marked
 * 'Start' in the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * @author bramanarayan
 * @date May 29, 2020
 */
public class UniquePaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UniquePaths solution = new UniquePaths();
		System.out.println(solution.uniquePaths(3, 2));
		System.out.println(solution.uniquePaths(7, 3));
	}

	// No need of any extra padding in DP for this problem
	public int uniquePaths(int m, int n) {
		int[][] res = new int[n][m];
		for (int i = 0; i < m; i++)
			res[0][i] = 1;
		for (int i = 0; i < n; i++)
			res[i][0] = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				
				res[i][j] = res[i][j - 1] + res[i - 1][j] ;
			}
		}
		return res[n-1][m-1];
	}

}
