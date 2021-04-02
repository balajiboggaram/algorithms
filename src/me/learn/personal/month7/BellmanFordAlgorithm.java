/**
 * 
 */
package me.learn.personal.month7;

/**
 * Title : Watch Abdul Bari video
 * https://www.youtube.com/watch?v=FtN3BYH2Zes
 * 
 * Date : Mar 5, 2021
 * 
 * @author bramanarayan
 *
 */

// Single source shortest path in a graph
// graph can have -ve weights
// cons : algo cannot find correct answer if graph has -ve edge cycle.
// O(n*n) 
public class BellmanFordAlgorithm {

	// if input is a graph matrix
	void BellmanFord(int graph[][], int V, int E, int src) {

		// Initialize distance of all vertices as infinite.
		int[] dis = new int[V];
		for (int i = 0; i < V; i++)
			dis[i] = Integer.MAX_VALUE;

		// initialize distance of source as 0
		dis[src] = 0;

		// Relax all edges |V| - 1 times. A simple
		// shortest path from src to any other
		// vertex can have at-most |V| - 1 edges
		for (int i = 0; i < V - 1; i++) { // you have to relax V-1 # of times

			for (int j = 0; j < E; j++) {
				if (dis[graph[j][0]] != Integer.MAX_VALUE && dis[graph[j][0]] + graph[j][2] < dis[graph[j][1]])
					dis[graph[j][1]] = dis[graph[j][0]] + graph[j][2];
			}
		}

		// Check for one more time, if you are able to relax -> then this graph has -ve
		// wieght cycle
		// check for negative-weight cycles.
		// The above step guarantees shortest
		// distances if graph doesn't contain
		// negative weight cycle. If we get a
		// shorter path, then there is a cycle.
		for (int i = 0; i < E; i++) {
			int x = graph[i][0];
			int y = graph[i][1];
			int weight = graph[i][2];
			if (dis[x] != Integer.MAX_VALUE && dis[x] + weight < dis[y])
				System.out.println("Graph contains negative" + " weight cycle");
		}

		System.out.println("Vertex Distance from Source");
		for (int i = 0; i < V; i++)
			System.out.println(i + "\t\t" + dis[i]);
	}

}
