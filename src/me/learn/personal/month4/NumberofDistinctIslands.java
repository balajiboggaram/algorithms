/**
 * 
 */
package me.learn.personal.month4;

import java.util.HashSet;
import java.util.Set;

/**
 * Title 694 : 
 * 
 * 
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.

Example 1:

11000
11000
00011
00011

Given the above grid map, return 1.

Example 2:

11011
10000
00001
11011
 * 
 * @author bramanarayan
 * @date Aug 20, 2020
 */
public class NumberofDistinctIslands {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NumberofDistinctIslands solution = new NumberofDistinctIslands();
		System.out.println(solution.numDistinctIslands(
				new int[][] { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 1 } }));
		
		//[[0,0,1,0,1,0,1,1,1,0,0,0,0,1,0,0,1,0,0,1,1,1,0,1,1,1,0,0,0,1,1,0,1,1,0,1,0,1,0,1,0,0,0,0,0,1,1,1,1,0],
		//[0,0,1,0,0,1,1,1,0,0,1,0,1,0,0,1,1,0,0,1,0,0,0,1,0,1,1,1,0,0,0,0,0,0,0,1,1,1,0,0,0,1,0,1,1,0,1,0,0,0],
		//[0,1,0,1,0,1,1,1,0,0,1,1,0,0,0,0,1,0,1,0,1,1,1,0,1,1,1,0,0,0,1,0,1,0,1,0,0,0,1,1,1,1,1,0,0,1,0,0,1,0],
		//[1,0,1,0,0,1,0,1,0,0,1,0,0,1,1,1,0,1,0,0,0,0,1,0,1,0,0,1,0,1,1,1,0,1,0,0,0,1,1,1,0,0,0,0,1,1,1,1,1,1]]

	}

	// You can use directions as String to compute if the pattern of island is
	// already found or not.
	// keep adding them to a set and then return total set size....
	
	// fix some test cases
	public int numDistinctIslands(int[][] a) {

		Set<String> set = new HashSet<>();

		int m = a.length;
		if (m == 0)
			return 0;
		int n = a[0].length;

		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if (a[i][j] == 1 && !visited[i][j]) {
					StringBuilder sb = new StringBuilder();
					sb.append("O"); // origin
					markIsland(a, visited, i, j, sb);
					set.add(sb.toString());
				}
			}
		}

		System.out.println(set);
		return set.size();
	}

	private void markIsland(int[][] a, boolean[][] visited, int i, int j, StringBuilder sb) {
		visited[i][j] = true;
		int[] row = new int[] { 0, -1, 0, 1 };
		int[] col = new int[] { -1, 0, 1, 0 };
		char[] dir = new char[] { 'L', 'U', 'R', 'D' };

		for (int k = 0; k < 4; k++) {
			if (isSafe(a, visited, i + row[k], j + col[k])) {
				sb.append(dir[k]);
				markIsland(a, visited, i + row[k], j + col[k], sb);
			}
		}
	}

	private boolean isSafe(int[][] a, boolean[][] visited, int i, int j) {
		return i >= 0 && j >= 0 && i < a.length && j < a[0].length && !visited[i][j] && a[i][j] == 1;
	}
}