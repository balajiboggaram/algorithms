/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 304, 303 :
 * 
 * Date : Jan 8, 2021
 * 
 * @author bramanarayan
 *
 */
public class RangeSumQuery2DImmutableMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		NumMatrix solution = new NumMatrix(new int[][] { {} });
	}

}

//the matrix values will not change
class NumMatrix {

	int[][] presum;

	boolean isEmpty;

	public NumMatrix(int[][] matrix) {

		int m = matrix.length;
		int n = 0;
		if (m == 0)
			isEmpty = true;
		if (m != 0) {
			n = matrix[0].length;
		}

		// row sum and col sum
		presum = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				presum[i][j] = presum[i - 1][j] + presum[i][j - 1] + matrix[i - 1][j - 1] - presum[i - 1][j - 1];
			}
		}

	}

	// sub matrix, problem : 304
	public int sumRegion(int row1, int col1, int row2, int col2) {

		if (isEmpty)
			return 0;

		int full = presum[row2 + 1][col2 + 1];
		int left = presum[row2 + 1][col1];
		int up = presum[row1][col2 + 1];
		int common = presum[row1][col1];

		return full - left - up + common;

	}

	// full matrix problem : 303
	public int sumRange(int i, int j) {
		if(isEmpty) return 0;
		return presum[i+1][j+1];
	}
}
