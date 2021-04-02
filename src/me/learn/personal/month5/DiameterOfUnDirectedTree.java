/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Title 1245 :
 * 
 * Date : Dec 27, 2020
 * 
 * @author bramanarayan
 *
 */
public class DiameterOfUnDirectedTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Find the diameter of undirected (bidirectional) Tree. Note that this is not a
	// binary tree.
	// This is the most famous problem in Google. Nodes are numbered from 0 to ..

	public int treeDiameter(int[][] edges) {

		int n = edges.length + 1;

		// Initialization of graph as adjacency list
		List<Set<Integer>> adjList = new ArrayList<Set<Integer>>();
		for (int i = 0; i < edges.length + 1; ++i) {
			adjList.add(new HashSet<Integer>());
		}

		// Edge (u ----> v)
		for (int[] edge : edges) {
			Integer u = edge[0], v = edge[1];
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}

		// 1). find one of the farthest nodes(LEAF) farthest_node, distance_1 = bfs(0)
		Node fathestNode = bfs(0, n, adjList);

		// 2). find the other farthest node (LEAF) and the distance between two farthest nodes
		// another_farthest_node, distance_2 = bfs(farthest_node)
		Node result = bfs(fathestNode.index, n, adjList);

		return result.dist;
	}

	/**
	 * return the farthest node from the 'start' node and the distance between them.
	 */
	private Node bfs(int start, int n, List<Set<Integer>> graph) {

		int[] distance = new int[n];
		Arrays.fill(distance, -1);

		Queue<Integer> q = new LinkedList<Integer>();

		q.add(start);
		distance[start] = 0;

		while (!q.isEmpty()) {
			int u = q.poll();

			Set<Integer> neighbours = graph.get(u); // get all the v's
			for (Integer v : neighbours) {
				if (distance[v] == -1) {
					// not visited yet
					q.add(v);
					distance[v] = distance[u] + 1;
				}
			}
		}

		// Find the maximum distance node
		int node = start;
		int max = -1;
		for (int i = 0; i < distance.length; i++) {
			if (max < distance[i]) {
				max = distance[i];
				node = i;
			}
		}

		return new Node(node, max);

	}

	class Node {
		public Node(int index, int dist) {
			this.index = index; // just an id for node
			this.dist = dist;
		}

		int index;
		int dist;
	}

}
