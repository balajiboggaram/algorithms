/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Title 261 :
 * 
 * Date : Jan 1, 2021
 * 
 * @author bramanarayan
 *
 */

//https://leetcode.com/problems/graph-valid-tree/solution/ MOTHER of ALL
public class CanGraphAValidTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Given list of edges, Can I graph them to a valid tree ? Note that each node
	// can hane only ONE PARENT.

	// The trick here is if I can get the # of connected components as 1 + no
	// cycles, viola, yes
	// you can graph to a tree. Else sorry :( nope - you cannot graph the edges to a
	// tree.

	// To check if its a single connected component, we can use DFS, However to
	// detect a cycle, there should not be any backedge.
	// A backedge is an edge to node which is already been visited.
	// We keep track of all the nodes visited, at any point, if we get the neighbour
	// node from one of already seen (other than node itself), then its a cycle

	// ITERATIVE DFS
	public boolean validTree(int n, int[][] edges) {

		List<List<Integer>> adjacencyList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjacencyList.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			adjacencyList.get(edge[0]).add(edge[1]);
			adjacencyList.get(edge[1]).add(edge[0]);
		}

		Map<Integer, Integer> parent = new HashMap<>();
		parent.put(0, -1);
		
		Stack<Integer> stack = new Stack<>();
		stack.push(0);

		while (!stack.isEmpty()) {
			int node = stack.pop();
			for (int neighbour : adjacencyList.get(node)) {
				
				// trace this : Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]], you will understand.
				// this is a trival cycle, a legit edge so ignore
				if (parent.get(node) == neighbour) { // 0->1 is legit. When you process node '1', if its parent is '0' -> you should let it go as its legit. hence this condition
					continue;
				}
				if (parent.containsKey(neighbour)) {
					return false;
				}
				stack.push(neighbour);
				parent.put(neighbour, node);
			}
		}

		return parent.size() == n;
	}
	
	
	// RECURSIVE DFS
	 // (This is similar to # of strongly connected, except a set instead on visited)
    private List<List<Integer>> adjacencyList = new ArrayList<>();
    private Set<Integer> seen = new HashSet<>();
    
    
    public boolean validTreeRecursiveDFS(int n, int[][] edges) {
        
        if (edges.length != n - 1) return false;
        
        // Make the adjacency list.
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        
        // Carry out depth first search.
        dfs(0);
        // Inspect result and return the verdict.
        return seen.size() == n;   
    }
    
    public void dfs(int node) {
        if (seen.contains(node)) return;
        seen.add(node);
        for (int neighbour : adjacencyList.get(node)) {
            dfs(neighbour);
        }
    }
}
