/**
 * 
 */
package me.learn.personal.month7;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Title 785 : 
 * 
 * Date : Feb 26, 2021
 * 
 * @author bramanarayan
 *
 */
public class IsGraphBipartiteColoringBased {
	
	//IDEA : 
	/**
	 * One approach is to check whether the graph is 2-colorable or not using backtracking algorithm m 
	 * coloring problem. 
		Following is a simple algorithm to find out whether a given graph is Birpartite or not using Breadth First Search (BFS). 
		1. Assign RED color to the source vertex (putting into set U). 
		2. Color all the neighbors with BLUE color (putting into set V). 
		3. Color all neighbor’s neighbor with RED color (putting into set U). 
		4. This way, assign color to all vertices such that it satisfies all the constraints of m way coloring problem where m = 2. 
		5. While assigning colors, if we find a neighbor which is colored with same color as current vertex,
		 then the graph cannot be colored with 2 vertices (or graph is not Bipartite) 

	 */
	
	 // graph here source -> direct edges [[1,2,3],[0,2],[0,1,3],[0,2]]
	// example : 1 is source, 2 and 3 are direct destiantions from 1
	public boolean isBipartite(int[][] graph) {
		// 1- red , 2 - blue
        // color map of the nodes
		Map<Integer, Integer> map = new HashMap<>();
        
		// Try to start at every index. i itself is the node's index
        for (int i = 0; i < graph.length; i++){
        	
            if(graph[i].length != 0 && !map.containsKey(i)){
            	
                Queue<Integer> queue = new LinkedList<>();
                map.put(i, 1); // color with RED 
                queue.offer(i); // add the source to queue
                
                while(!queue.isEmpty()){
                    
                	int uNode = queue.poll();
                    int currColor = map.get(uNode);
                    
                    // Get all the destination
                    for(int vNode : graph[uNode]){
                    	
                        if(!map.containsKey(vNode)){
                            int newColor = (currColor == 1) ? 2 : 1; // paint with blue
                            map.put(vNode, newColor);
                            queue.offer(vNode);
                        }else if(map.get(vNode) == currColor){
                        	// if both u and v are painted with same color, then it can never be Bi Partite.
                            return false;
                        }
                    
                    }
                }
            }
        }
        return true;
    }

}
