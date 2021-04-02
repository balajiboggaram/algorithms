/**
 * 
 */
package me.learn.personal.month5;

import java.util.Arrays;

/**
 * Title 289 :
 * 
 * Date : Dec 30, 2020
 * 
 * @author bramanarayan
 *
 */
public class GameOfLife {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int[] row = new int[] { -1, -1, -1, 0, 1, 1, 1, 0 };
	int[] col = new int[] { -1, 0, 1, 1, 1, 0, -1, -1 };

	public void gameOfLife(int[][] a) {
		int m = a.length;
		int n = a[0].length;

		int[][] copy = new int[m][n];

		// copy the array
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				copy[i][j] = a[i][j];
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int liveNeighbors = getLive(copy, i, j);

				if (a[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
					a[i][j] = 0;
				}

				if (a[i][j] == 0 && liveNeighbors == 3) {
					a[i][j] = 1;
				}

			}
		}
	}

	private int getLive(int[][] copy, int i, int j) {
		int count = 0;
		for (int k = 0; k < 8; k++) {
			
			int rowth = i + row[k];
			int colth = j + col[k];
			if (rowth >= 0 && rowth < copy.length && colth >= 0 && colth < copy[0].length && copy[rowth][colth] == 1) {
				count++;
			}
		}
		return count;
	}
	
	// To solve it in O(1) space, all that you need is to change the transformation to negative values.
	// i.e  if you ever change a 1 to 0 -> mark it as -1
	// i.e if you ever change a 0 to 1, then mark it as 2. 
	// while you do comparisions, you can consider the above markings.

}
