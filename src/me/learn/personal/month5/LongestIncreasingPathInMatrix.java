/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 329 :
 * 
 * Date : Jan 8, 2021
 * 
 * @author bramanarayan
 *
 */
public class LongestIncreasingPathInMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int[] rows = new int[] { 0, -1, 0, 1 };
	int[] cols = new int[] { -1, 0, 1, 0 };

	// DFS with memoization
	public int longestIncreasingPath(int[][] a) {
		int m = a.length;
		int n = a[0].length;

		// cache[i][j] -> each cell stores the max increasing path with matrix if i rows
		// and j columns
		int[][] dp = new int[m][n];

		int result = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int length = dfs(a, dp, i, j, m, n);
				result = Math.max(length, result);
			}
		}
		return result;
	}

	// in most of the backtracking problems, you can avoid by solving using the
	// cache as optimization
	private int dfs(int[][] a, int[][] cache, int i, int j, int m, int n) {
		if (cache[i][j] != 0)
			return cache[i][j];

		int curMax = 1;
		for (int k = 0; k < 4; k++) {
			int row = rows[k] + i;
			int col = cols[k] + j;

			if (row < 0 || row >= m || col < 0 || col >= n || a[row][col] <= a[i][j])
				continue;

			int len = dfs(a, cache, row, col, m, n) + 1;

			curMax = Math.max(curMax, len);

		}

		cache[i][j] = curMax;
		return curMax;

	}

}
