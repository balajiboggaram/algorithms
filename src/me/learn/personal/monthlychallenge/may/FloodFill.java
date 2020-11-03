/**
 * 
 */
package me.learn.personal.monthlychallenge.may;

/**
 * Title : An image is represented by a 2-D array of integers, each integer
 * representing the pixel value of the image (from 0 to 65535).
 * 
 * Given a coordinate (sr, sc) representing the starting pixel (row and column)
 * of the flood fill, and a pixel value newColor, "flood fill" the image.
 * 
 * To perform a "flood fill", consider the starting pixel, plus any pixels
 * connected 4-directionally to the starting pixel of the same color as the
 * starting pixel, plus any pixels connected 4-directionally to those pixels
 * (also with the same color as the starting pixel), and so on. Replace the
 * color of all of the aforementioned pixels with the newColor.
 * 
 * At the end, return the modified image.
 * 
 * @author bramanarayan
 * @date May 11, 2020
 */
public class FloodFill {

	int m; // total number of rows
	int n; // total number of columns
	int oldColor;
	int newColor;

	public static void main(String[] args) {
		FloodFill solution = new FloodFill();
		int[][] image = new int[][] {{1,1,1},{1,1,0},{1,0,1}};
		solution.floodFill(image, 1, 1, 2);
		
	}

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		this.m = image.length;
		this.n = image[0].length;

		// Image not possible
		if (sr >= m || sc >= n)
			return null;

		this.oldColor = image[sr][sc];
		this.newColor = newColor;

		boolean[][] visited = new boolean[m][n];
		colorFill(image, sr, sc, visited);

		this.oldColor = image[sr][sc];
		return image;
	}

	public void colorFill(int[][] a, int x, int y, boolean[][] visited) {
		if (isSafe(a, x, y, visited)) {
			visited[x][y] = true;
			
			if(a[x][y] != this.oldColor) {
				return;
			} 
			a[x][y] = this.newColor;
			colorFill(a, x-1, y, visited);
			colorFill(a, x, y-1, visited);
			colorFill(a, x, y+1, visited);
			colorFill(a, x+1, y, visited);
		}
	}

	private boolean isSafe(int[][] a, int x, int y, boolean[][] visited) {
		return x >= 0 && x < m && y >= 0 && y < n && !visited[x][y];
	}
}
