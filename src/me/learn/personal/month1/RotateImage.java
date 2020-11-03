/**
 * 
 */
package me.learn.personal.month1;

/**
 * Title 48 : You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Note:
 * 
 * You have to rotate the image in-place, which means you have to modify the
 * input 2D matrix directly. DO NOT allocate another 2D matrix and do the
 * rotation.
 * 
 * @author bramanarayan
 * @date May 19, 2020
 */
public class RotateImage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int mat[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int mat2[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int mat3[][] = { 
                {1, 2, 3}, 
                {4, 5, 6}, 
                {7, 8, 9} 
            }; 
		RotateImage solution = new RotateImage();
		solution.rotateAntiClock(mat);
		System.out.println("CLock wise");
		solution.rotate(mat3);

	}

	/**
	 * Clockwise Matrix rotation
	 */
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int x = 0; x < n / 2; x++) {
			for (int y = x; y < n - x - 1; y++) {
				int temp = matrix[x][y];
				matrix[x][y] = matrix[n - 1 - y][x];
				matrix[n - 1 - y][x] = matrix[n - 1 - x][n - 1 - y];
				matrix[n - 1 - x][n - 1 - y] = matrix[y][n - 1 - x];
				matrix[y][n - 1 - x] = temp;
			}
		}
		displayMatrix(n, matrix);
	}

	public void rotateAntiClock(int[][] matrix) {
		int n = matrix.length;
		for (int x = 0; x < n / 2; x++) {
			for (int y = x; y < n - x - 1; y++) {
				int temp = matrix[x][y];
				matrix[x][y] = matrix[y][n - 1 - x];
				matrix[y][n - x - 1] = matrix[n - 1 - x][n - 1 - y];
				matrix[n - 1 - x][n - 1 - y] = matrix[n - 1 - y][x];
				matrix[n - 1 - y][x] = temp;
			}
		}
		displayMatrix(n, matrix);
	}

	void displayMatrix(int N, int mat[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(" " + mat[i][j]);

			System.out.print("\n");
		}
		System.out.print("\n");
	}

}
