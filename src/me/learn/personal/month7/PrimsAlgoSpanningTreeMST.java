/**
 * 
 */
package me.learn.personal.month7;

/**
 * Title : https://www.youtube.com/watch?v=4ZlRH0eK-qQ
 * 
 * Date : Feb 27, 2021
 * 
 * @author bramanarayan
 *
 */
public class PrimsAlgoSpanningTreeMST {

	int V; // Total number of vertices

	void primMST(int cost[][]) {

		// SET TO KNOW IF THE VERTEX IS ALREADY CONSIDERED IN MST or NOT
		boolean[] inMST = new boolean[V];

		// Include first vertex in MST
		inMST[0] = true;

		// Keep adding edges while number of included edges does not become V-1.
		// You will always pick a smallest edge from  directly connected(already in MST) -----> to -----> (not in MST)
		// in MST, if you have V vertices, you will always have V-1 # of edges to form  a MST.
		int edgeCount = 0, mincost = 0;
		while (edgeCount < V - 1) {

			// Find minimum weight valid edge.
			int min = Integer.MAX_VALUE, a = -1, b = -1;
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					if (cost[i][j] < min) {
						if (isValidEdge(i, j, inMST)) {
							min = cost[i][j];
							a = i;
							b = j;
						}
					}
				}
			}

			if (a != -1 && b != -1) {
				System.out.printf("Edge %d:(%d, %d) cost: %d \n", edgeCount++, a, b, min);
				mincost = mincost + min;
				inMST[b] = inMST[a] = true;
			}
		}
		System.out.printf("\n Minimum cost = %d \n", mincost);
	}

	// Returns true if edge u-v is a valid edge to be
	// include in MST. An edge is valid if one end is
	// already included in MST and other is not in MST.
	static boolean isValidEdge(int u, int v, boolean[] inMST) {
		if (u == v)
			return false;
		if (inMST[u] == false && inMST[v] == false)
			return false;
		else if (inMST[u] == true && inMST[v] == true)
			return false;
		return true;
	}

}
