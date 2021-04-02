/**
 * 
 */
package me.learn.personal.month7;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Title 909 :
 * 
 * Date : Feb 26, 2021
 * 
 * @author bramanarayan
 *
 */
public class SnakeAndLadderGameMinimumMovesToReachEnd {

	// COnvert to 1D array
	public int snakesAndLadders(int[][] board) {

		int N = 0;
		if ((N = board.length) == 0)
			return 0;

		int[] nBoard = new int[N * N + 1];
		int t = 1;
		boolean left2right = true;

		for (int i = N - 1; i >= 0; i--) { // last row to top row
			if (left2right) {
				for (int j = 0; j < N; j++)
					nBoard[t++] = board[i][j]; // left to right
			} else {
				for (int j = N - 1; j >= 0; j--)
					nBoard[t++] = board[i][j]; // right to left
			}
			left2right = !left2right;
		}
		// System.out.println(Arrays.toString(nBoard));

		// Now traverse via BFS
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		int steps = 0;
		boolean[] visited = new boolean[N * N + 1];
		visited[1] = true;

		while (!q.isEmpty()) {

			steps++;
			int size = q.size();

			for (int i = 0; i < size; i++) {
				int curPosition = q.poll();

				// try all the 6 poosibilitues in dice roll over
				for (int j = 1; j <= 6; j++) {
					int nextPosition = curPosition + j;

					if (nBoard[nextPosition] != -1)
						nextPosition = nBoard[nextPosition];

					if (visited[nextPosition]) // if this cell is already visited, then ignore
						continue;

					if (nextPosition == N * N) // we reached the end, so steps is the answer
						return steps;

					visited[nextPosition] = true; // mark the nextPosition
					
					q.offer(nextPosition);
				}
			}
		}
		return -1;
	}

}
