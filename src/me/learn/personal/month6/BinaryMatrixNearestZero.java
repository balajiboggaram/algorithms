/**
 * 
 */
package me.learn.personal.month6;

/**
 * Title :
 * 
 * Date : Jan 30, 2021
 * 
 * @author bramanarayan
 *
 */
public class BinaryMatrixNearestZero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] updateMatrix(int[][] matrix) {

		int m = matrix.length;
		int n = matrix[0].length;

		if (m == 0 || n == 0) {
			return matrix;
		}

		int[][] dis = new int[m][n];

		int range = m * n;

		// 2 pass solution
		// top and left only
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					dis[i][j] = 0;
				} else {
					int upCell = (i > 0) ? dis[i - 1][j] : range; // range -> this is just to indicate that I did not see any nearest zero in top or left. tats all
					int leftCell = (j > 0) ? dis[i][j - 1] : range;
					dis[i][j] = Math.min(upCell, leftCell) + 1;
				}
			}
		}

		// bottom and right only (start from bottom right corner)
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (matrix[i][j] == 0) {
					dis[i][j] = 0;
				} else {
					int downCell = (i < m - 1) ? dis[i + 1][j] : range;
					int rightCell = (j < n - 1) ? dis[i][j + 1] : range;
					dis[i][j] = Math.min(Math.min(downCell, rightCell) + 1, dis[i][j]); // now, dis[i][j] will hold the answer traversed from top left path
				}
			}
		}

		return dis;
	}

}
