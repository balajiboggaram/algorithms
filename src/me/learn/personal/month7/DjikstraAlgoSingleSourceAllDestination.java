/**
 * 
 */
package me.learn.personal.month7;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Title : https://www.youtube.com/watch?v=XB4MIexjvY0
 * Date : Feb 27, 2021
 * 
 * @author bramanarayan
 *
 */
// SINGLE SOURCE SHORTEST PATH
public class DjikstraAlgoSingleSourceAllDestination {

	private int dist[]; // shortest distance from source vertex to ALL other nodes
	private Set<Integer> settled; // for number of nodes where the shortest distance is computed already or visited
	private PriorityQueue<Node> pq; // to get the minimum distance node from non-computed node set.
	private int V; // Number of vertices
	List<List<Node>> adj; // This can be a graph matrix also. Works for both directed and undirected graph

	public DjikstraAlgoSingleSourceAllDestination() {
		this.V = V;
		dist = new int[V];
		settled = new HashSet<Integer>();
		pq = new PriorityQueue<Node>(V, new Node());
	}

	// Function for Dijkstra's Algorithm
	public void dijkstra(List<List<Node>> adj, int src) {
		this.adj = adj;

		for (int i = 0; i < V; i++)
			dist[i] = Integer.MAX_VALUE;

		// Add source node to the priority queue
		pq.add(new Node(src, 0));

		// Distance to the source is 0
		dist[src] = 0;
		while (settled.size() != V) {

			// remove the minimum distance node from the priority queue
			int u = pq.remove().node;

			// adding the node whose distance is finalized
			settled.add(u);

			processNeighbours(u);
		}
	}

	// Function to process all the neighbours of the passed node
	private void processNeighbours(int u) {
		
		int edgeDistance = -1;
		int newDistance = -1;

		// All the neighbors of v
		for (int i = 0; i < adj.get(u).size(); i++) {
			Node v = adj.get(u).get(i);

			// If current node hasn't already been processed
			if (!settled.contains(v.node)) {
				edgeDistance = v.cost;
				newDistance = dist[u] + edgeDistance;

				// If new distance is cheaper in cost
				if (newDistance < dist[v.node])
					dist[v.node] = newDistance;

				// Add the current node to the queue
				pq.add(new Node(v.node, dist[v.node]));
			}
		}
	}

	// Class to represent a node in the graph
	class Node implements Comparator<Node> {
		public int node;
		public int cost;

		public Node() {
		}

		public Node(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}

		@Override
		public int compare(Node node1, Node node2) {
			if (node1.cost < node2.cost)
				return -1;
			if (node1.cost > node2.cost)
				return 1;
			return 0;
		}
	}

}
