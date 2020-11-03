/**
 * 
 */
package me.learn.personal.month2;

/**
 * Title 240 : 
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted in ascending from left to right.
    Integers in each column are sorted in ascending from top to bottom.

Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]

Given target = 5, return true.
 * 
 * @author bramanarayan
 * @date Jun 9, 2020
 */
public class Search2DMatrixTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Search2DMatrixTwo solution = new Search2DMatrixTwo();
		int[][] matrix = new int[][] {{1,5,9},{10,11,13},{12,13,15}};
		
		System.out.println(solution.searchMatrix(matrix, 5));
	}

	/**
	 * O(m+n) this is cos we traverse every element on the worst case.
	 */
	public boolean searchMatrix(int[][] a, int target) {
		int m = a.length;
		if (m == 0)
			return false;
		int n = a[0].length;
		if (n == 0)
			return false;
		int i = 0;
		int j = n - 1;
		while (i < m && j >= 0) {
			if (target == a[i][j])
				return true;
			else if (target > a[i][j])
				i++;
			else
				j--;
		}
		return false;
	}

}
