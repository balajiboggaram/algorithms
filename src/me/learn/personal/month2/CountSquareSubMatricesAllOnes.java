/**
 * 
 */
package me.learn.personal.month2;

/**
 * Title 1277 :
 * 
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.

 * 
 * @author bramanarayan
 * @date Jun 18, 2020
 */
public class CountSquareSubMatricesAllOnes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CountSquareSubMatricesAllOnes solution = new CountSquareSubMatricesAllOnes();
		System.out.println(solution.countSquares(new int[][] {{0,1,1,1},{1,1,1,1},{0,1,1,1}}));
		System.out.println(solution.countSquares(new int[][] {{1,0,1},{1,1,0},{1,1,0}}));

	}

	// DYNAMIC PROGRAMMING
	// left top and diagonal left - check all the elements
	public int countSquares(int[][] matrix) {

		int m = matrix.length;
		int n = matrix[0].length;

		int result = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i > 0 && j > 0 && matrix[i][j] > 0) {
					int temp = Math.min(Math.min(matrix[i - 1][j - 1], matrix[i][j - 1]), matrix[i - 1][j]);
					matrix[i][j] = temp + 1;
				}
				result += matrix[i][j];
			}
		}
		return result;

	}

}
