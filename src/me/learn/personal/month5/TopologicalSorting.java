/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Title :
 * 
 * Date : Jan 2, 2021
 * 
 * @author bramanarayan
 *
 *
 * You can also detect a cycle using some smartness with topo : 
 * https://www.geeksforgeeks.org/detect-cycle-in-directed-graph-using-topological-sort/
 * 
 *
 */
// See CourseScheduleOrder problem for topo template
public class TopologicalSorting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Map<Integer, List<Integer>> map = new HashMap<>(); // graph
	Stack<Integer> st = new Stack<Integer>();

	// n -> # of vertices
	// edges -> DIRECTIONAL graph
	public void topologicalSortOrder(int n, int[][] edges) {

		// Convert the edges to adjacency list graph

		for (int i = 0; i < n; i++) {
			map.put(i, new ArrayList<Integer>());
		}
		for (int i = 0; i < edges.length; i++) {
			map.get(edges[i][0]).add(edges[i][1]); // 0->1 uni directional edge
		}

		// once you have the graph
		boolean[] visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				mark(visited, i);
			}
		}

		// CONTENTS of Stack would be the topological order would be the result
		while(!st.isEmpty()) {
			System.out.println(st.pop());
		}
	}

	private void mark(boolean[] visited, int i) {
		
		visited[i] = true;
		
		// dont push the node yet, We need to process all its dependencies before I can mark this completed.
		// in other words, i need to build all the dependent projects of this to build this project i successsfully.
		
		for(int dependency : map.get(i)) {
			if(!visited[dependency]) {
				mark(visited, dependency);				
			}
		}
		
		// after all the dependencies are built, now push the ith project as completed. So into our stack
		st.push(i);
	}

}
