/**
 * 
 */
package me.learn.personal.month2;

/**
 * Title 463 :
 * 
 *  You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.


Example:

Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16
 * 
 * @author bramanarayan
 * @date Aug 15, 2020
 */
public class IslandPerimeter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IslandPerimeter solution = new IslandPerimeter();
		System.out.println(solution.islandPerimeter(new int[][] { {0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}}));
	}

	public int islandPerimeter(int[][] a) {
		int m = a.length;
		int n = a[0].length;
		int count = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 1) {
					count += 4; // just blindly add here

					if (i > 0 && a[i-1][j] == 1) {
						count = count - 2; // remove one from cur cell, and one from top cell
					}

					if (j > 0 && a[i][j-1] == 1) {
						count = count - 2; // remove one from cur cell and one from left cell
					}
				}

			}
		}
		return count;
	}

}
