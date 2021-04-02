/**
 * 
 */
package me.learn.personal.month7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Title 1135 :
 * 
 * Date : Feb 25, 2021
 * 
 * @author bramanarayan
 *
 */
public class MinimumSpanningTreeCities {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
    Build the graph based on the edges.
    Randomly pick a node to start with(in this case, pick node with id 1).
    Pop the edge with least cost:
        if the edge does NOT exist in the MST(visited set), add 
                 its cost to total cost and add new edges starting from the end node to the queue.
        if the edge does exist in the MST(visted set)

	 */
	public int minimumCost(int N, int[][] connections) {
		
		Map<Integer, List<int[]>> graph = new HashMap<>();
		
		PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		
		Set<Integer> visited = new HashSet<>();
		int costs = 0;

		for (int[] conn : connections) {
			int n1 = conn[0], n2 = conn[1], cost = conn[2];

			graph.computeIfAbsent(n1, (k) -> new ArrayList<>());
			graph.computeIfAbsent(n2, (k) -> new ArrayList<>());
			graph.get(n1).add(new int[] { n2, cost });
			graph.get(n2).add(new int[] { n1, cost });
		}

		heap.add(new int[] { 1, 1, 0 });
		while (!heap.isEmpty()) {
			int[] conn = heap.poll();
			int n1 = conn[0], n2 = conn[1], cost = conn[2];

			if (!visited.contains(n2)) {
				costs += cost;
				visited.add(n2);
				for (int[] next : graph.get(n2)) {
					heap.add(new int[] { n2, next[0], next[1] });
				}
			}
		}

		return visited.size() == N ? costs : -1;
	}
}
	
	// OR
	
	class MST { 
	    // Number of vertices in the graph 
	    private static final int V = 5; 
	  
	    // A utility function to find the vertex with minimum key 
	    // value, from the set of vertices not yet included in MST 
	    // find the minimum from the cut
	    int minKey(int key[], Boolean mstSet[]) 
	    { 
	        // Initialize min value 
	        int min = Integer.MAX_VALUE, min_index = -1; 
	  
	        for (int v = 0; v < V; v++) 
	            if (mstSet[v] == false && key[v] < min) { 
	                min = key[v]; 
	                min_index = v; 
	            } 
	  
	        return min_index; 
	    } 
	  
	    // A utility function to print the constructed MST stored in 
	    // parent[] 
	    void printMST(int parent[], int graph[][]) 
	    { 
	        System.out.println("Edge \tWeight"); 
	        for (int i = 1; i < V; i++) 
	            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]); 
	    } 
	  
	    // ENTRY 
	    // Function to construct and print MST for a graph represented 
	    // using adjacency matrix representation 
	    void primMST(int graph[][]) 
	    { 
	        // Array to store constructed MST 
	        int parent[] = new int[V]; 
	  
	        // Key values used to pick minimum weight edge in cut 
	        int key[] = new int[V]; 
	  
	        // To represent set of vertices included in MST 
	        Boolean mstSet[] = new Boolean[V]; 
	  
	        // Initialize all keys as INFINITE 
	        for (int i = 0; i < V; i++) { 
	            key[i] = Integer.MAX_VALUE; 
	            mstSet[i] = false; 
	        } 
	  
	        // Always include first 1st vertex in MST. 
	        key[0] = 0; // Make key 0 so that this vertex is 
	        // picked as first vertex 
	        parent[0] = -1; // First node is always root of MST 
	  
	        // The MST will have V vertices 
	        for (int count = 0; count < V - 1; count++) { 
	        	
	            // Pick thd minimum 'key' vertex from the set of vertices not yet included in MST 
	            int u = minKey(key, mstSet); 
	            // HERE YOU NEED TO ADD THE COST OF key[u]

	  
	            // Add the picked vertex to the MST Set 
	            mstSet[u] = true; 
	  
	            // Update key value and parent index of the adjacent 
	            // vertices of the picked vertex. Consider only those 
	            // vertices which are not yet included in MST 
	            for (int v = 0; v < V; v++) 
	  
	                // graph[u][v] is non zero only for adjacent vertices of m 
	                // mstSet[v] is false for vertices not yet included in MST 
	                // Update the key only if graph[u][v] is smaller than key[v] 
	                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) { 
	                    parent[v] = u; 
	                    key[v] = graph[u][v]; 
	                } 
	        } 
	  
	        // print the constructed MST 
	        printMST(parent, graph); 
	    } 

}
