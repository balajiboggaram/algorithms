/**
 * 
 */
package me.learn.personal.month7;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Title 773 :
 * 
 * Date : Feb 26, 2021
 * 
 * @author bramanarayan
 *
 */

/**
 *  Directions indices - how it can traverse ?
 *
0 1 2
3 4 5 --> 0 can go to {1, 3}

1 0 2
3 4 5 --> 0 can go to index of {0,2,4}

1 2 0
3 4 5 --> 0 can go to {1, 5}

1 2 3
0 4 5 --> 0 can go to {0,4}

1 2 3
4 0 5 --> 0 can go to {1, 3, 5}

1 2 3
4 5 0 --> 0 can go to {2, 4}
 *
 */
public class SlidingPuzzleMinimumMovesToTargetState {
	
	
	// Store each matrix snapshot as possible state in BFS. 
	// if your current snapshot == target snapshot - Viola you are done
	public int slidingPuzzle(int[][] board) {
		
		String targetSnapshot = "123450";
		
		// starting state
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				sb.append(board[i][j]);
			}
		}
		String startSnapshot = sb.toString(); 

		
		// To track visited states
		HashSet<String> visited = new HashSet<>();
		
		// all the positions 0 can be swapped to
		int[][] dirs = new int[][] { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };
		
		Queue<String> queue = new LinkedList<>();
		
		queue.offer(startSnapshot);
		visited.add(startSnapshot);
		
		int level = 0;
		while (!queue.isEmpty()) {
			
			// level count, has to use size control here, otherwise not needed
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				String cur = queue.poll();
				
				if (cur.equals(targetSnapshot)) {
					return level;
				}
				
				int zeroPosition = cur.indexOf('0');
				// swap if possible
				for (int dir : dirs[zeroPosition]) {
					String next = swap(cur, zeroPosition, dir);
					if (visited.contains(next)) {
						continue;
					}
					visited.add(next);
					queue.offer(next);

				}
			}
			level++;
		}
		return -1;
	}

	private String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
	}

}
