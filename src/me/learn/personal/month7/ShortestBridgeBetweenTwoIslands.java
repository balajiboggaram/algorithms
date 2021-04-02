/**
 * 
 */
package me.learn.personal.month7;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Title 934 :
 * 
 * Date : Feb 26, 2021
 * 
 * @author bramanarayan
 *
 */
public class ShortestBridgeBetweenTwoIslands {

	// Step 1 : PAINT
	// Setp 2 : BFS -
	public int shortestBridge(int[][] A) {

		// First paint the island
		paint(A); // paint one island with int 2 (special value)
		
		Queue<int[]> q = new LinkedList<>(); // queue contains coordinates to do bfs
		boolean[][] visited = new boolean[A.length][A[0].length];

		
		// Initialize - Put all the coordinates on first island in to QUEUE
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (A[i][j] == 2) {
					q.add(new int[] { i, j });
					visited[i][j] = true;
				}
			}
		}

		int level = 0;
		while (!q.isEmpty()) {// level order bfs
			int size = q.size();
			for (int i = 0; i < size; i++) {
				
				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				if (A[x][y] == 1) {// found, then return
					return level - 1;
				}
				// add top
				if (x - 1 >= 0 && !visited[x - 1][y]) {
					q.add(new int[] { x - 1, y });
					visited[x - 1][y] = true;
				}
				// add bottom
				if (x + 1 < A.length && !visited[x + 1][y]) {
					q.add(new int[] { x + 1, y });
					visited[x + 1][y] = true;
				}
				// add left
				if (y - 1 >= 0 && !visited[x][y - 1]) {
					q.add(new int[] { x, y - 1 });
					visited[x][y - 1] = true;
				}
				// add right
				if (y + 1 < A[0].length && !visited[x][y + 1]) {
					q.add(new int[] { x, y + 1 });
					visited[x][y + 1] = true;
				}
			}
			level++; // next level
		}
		return -1;
	}

	public void paint(int[][] A) {// paint one island with int 2 or something
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (A[i][j] == 1) {
					dfs(i, j, A);
					return;
				}
			}
		}
	}

	public void dfs(int x, int y, int[][] A) {// helper function for paint function
		if (x < 0 || x > A.length - 1 || y < 0 || y > A[0].length - 1 || A[x][y] != 1) {
			return;
		}
		A[x][y] = 2;
		dfs(x - 1, y, A);
		dfs(x + 1, y, A);
		dfs(x, y - 1, A);
		dfs(x, y + 1, A);
	}

}
