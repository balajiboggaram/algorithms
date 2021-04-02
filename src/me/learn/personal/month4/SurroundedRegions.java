/**
 * 
 */
package me.learn.personal.month4;

import java.util.Arrays;

/**
 * Title 130 :
 * 
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X

Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.

 * 
 * @author bramanarayan
 * @date Aug 19, 2020
 */
public class SurroundedRegions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SurroundedRegions solution = new SurroundedRegions();
		solution.solve(new char[][] { { '0', '0', '0' }, { '0', 'O', 'O' }, { '0', '0', 'O' } });
		solution.solve(new char[][] { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } });
		solution.solve(new char[][] {});
	}

	// Start by marking the perimeter by DFS with 'E' some special character
	// Then iterate the whole matrix, flip E by 0 and 0 by X.
	// This is similar to # of islands problem
	public void solve(char[][] a) {

		int m = a.length;
		if (m == 0)
			return;
		int n = a[0].length;

		// mark the nodes first and last column // Change to E
		for (int i = 0; i < m; i++) {
			if (a[i][0] == 'O')
				markNodes(a, i, 0);

			if (a[i][n - 1] == 'O')
				markNodes(a, i, n - 1);
		}

		// mark the nodes first and last row
		for (int j = 0; j < n; j++) {
			if (a[0][j] == 'O')
				markNodes(a, 0, j);

			if (a[m - 1][j] == 'O')
				markNodes(a, m - 1, j);
		}

		// now iterate and flip it
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 'O')
					a[i][j] = 'X';
				if (a[i][j] == 'E')
					a[i][j] = 'O';

			}
		}
	}

	private void markNodes(char[][] a, int i, int j) {

		a[i][j] = 'E';
		int[] row = new int[] { 0, -1, 0, 1 };
		int[] col = new int[] { -1, 0, 1, 0 };
		for (int k = 0; k < 4; k++) {
			if (isSafe(a, i + row[k], j + col[k])) {
				markNodes(a, i + row[k], j + col[k]);
			}
		}
	}

	private boolean isSafe(char[][] a, int i, int j) {
		return i >= 0 && j >= 0 && i < a.length && j < a[0].length && a[i][j] == 'O';
	}

}
