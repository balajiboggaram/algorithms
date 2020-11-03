/**
 * 
 */
package me.learn.personal.month2;

/**
 * Title 1252 :
 * 
 * Given n and m which are the dimensions of a matrix initialized by zeros and
 * given an array indices where indices[i] = [ri, ci]. For each pair of [ri, ci]
 * you have to increment all cells in row ri and column ci by 1.
 * 
 * Return the number of cells with odd values in the matrix after applying the
 * increment to all indices.
 * 
 * @author bramanarayan
 * @date Jun 13, 2020
 */
public class CellsWithOddValuesInMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CellsWithOddValuesInMatrix solution = new CellsWithOddValuesInMatrix();
		System.out.println(solution.oddCells(2, 3, new int[][] { { 0, 1 }, { 1, 1 } }));
	}

	public int oddCells(int n, int m, int[][] indices) {

		int row[] = new int[n];
		int col[] = new int[m];
		int[][] res = new int[n][m];

		// Increment the row and col array based on indicies
		for (int i = 0; i < indices.length; i++) {

			int x = indices[i][0];
			int y = indices[i][1];

			row[x] += 1;
			col[y] += 1;
		}

		// Increment the row
		for (int i = 0; i < n; i++) {
			if (row[i] > 0) {
				int j = 0;
				while (j < m) {
					res[i][j] += row[i];
					j++;
				}
			}
		}
		// Increment the column
		for (int i = 0; i < m; i++) {
			if (col[i] > 0) {
				int j = 0;
				while (j < n) {
					res[j][i] += col[i];
				j++;
				}
			}
		}


		// Check the odd values
		int oddCount = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				oddCount = (res[i][j] % 2 != 0) ? oddCount + 1 : oddCount;
			}
		}
		return oddCount;
	}

}
