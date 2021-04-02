/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 1351 :
 * 
 * Date : Jan 4, 2021
 * 
 * @author bramanarayan
 *
 */
public class CountNegativenNumbersInSortedMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countNegatives(int[][] grid) {

		int m = grid.length;
		int n = grid[0].length;

		int i = 0;
		int j = n - 1;

		int count = 0;
		while (i < m && j >= 0) {
			if (grid[i][j] < 0) {
				--j;
				count += m - i;
			} else {
				++i;
			}
		}
		return count;
	}

}
