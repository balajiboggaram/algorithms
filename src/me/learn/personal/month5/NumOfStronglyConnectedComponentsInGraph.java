/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title 323 :
 * 
 * Date : Jan 1, 2021
 * 
 * @author bramanarayan
 *
 */
public class NumOfStronglyConnectedComponentsInGraph {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countComponents(int n, int[][] edges) {

		// Convert the edges to adjacency list
		if (n <= 1)
			return n;
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(i, new ArrayList<>());
		}
		for (int[] edge : edges) {
			map.get(edge[0]).add(edge[1]); // for bidirectional edge
			map.get(edge[1]).add(edge[0]);
		}

		// now do flood fill
		int result = 0;
		boolean[] visited = new boolean[n];
		for(int i = 0;i< n;i++) {
			if(!visited[i]) {
				result++;
				markVisited(visited, map, i);
			}
		}
		return result;

	}

	// similar to flood fill
	private void markVisited(boolean[] visited, Map<Integer, List<Integer>> map, int i) {
		if(i < visited.length) {
			
			if(visited[i]) return;
			
			if(!visited[i]) {
				visited[i] = true;
				for(int neigh : map.get(i)) {
					markVisited(visited, map, neigh);
				}
			}
			
		}
		
	}

}
