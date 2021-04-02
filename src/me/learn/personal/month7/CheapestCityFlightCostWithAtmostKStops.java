/**
 * 
 */
package me.learn.personal.month7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Title 787 :
 * 
 * Date : Feb 26, 2021
 * 
 * @author bramanarayan
 *
 */
public class CheapestCityFlightCostWithAtmostKStops {

	// Pure BFS based approach with caveat to store 'k'
	// flight[] -> [i,j, cost]
	public int findCheapestPrice(int n, int[][] flights, int src, int destination, int K) {

		
		// a pure distance between two nodes
		// source -> int[] {destination,cost} 0 index is destination, 1 index is cost
		// kind of adjacency list along with the cost in values(destinations)
		Map<Integer, List<int[]>> map = new HashMap<>();
		for (int[] flightTuple : flights) {
			map.putIfAbsent(flightTuple[0], new ArrayList<>());
			map.get(flightTuple[0]).add(new int[] { flightTuple[1], flightTuple[2] });
		}

		int level = 0;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { src, 0 });
		int ans = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				
				int[] curr = q.poll();
				
				int uNode = curr[0];
				int uDistance = curr[1]; // from source to uNode
				
				if (uNode == destination)
					ans = Math.min(ans, uDistance);
				
				if (!map.containsKey(uNode))
					continue;
				
				for (int[] neighbor : map.get(curr[0])) {
					
					int vNode = neighbor[0];
					int vDistance = neighbor[1];
					
					if (uDistance + vDistance > ans) // Pruning
						continue;
					
					q.offer(new int[] { vNode, uDistance + vDistance }); // to reach vNode = uDistance  + vdistance (from u to v)
				}
			}
			if (level++ > K)
				break;
		}
		return ans == Integer.MAX_VALUE ? -1 : ans;
	}

}
